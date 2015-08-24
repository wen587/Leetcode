/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number 
 * of rows like this: (you may want to display this pattern in a fixed font for 
 * better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a 
 * number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
 */

//只是能读懂
public class Solution {
    public String convert(String s, int nRows) {
        if (nRows == 1)
            return s;
 
        // each unit
        int amountInUnit = nRows + nRows - 2;
        int totalUnits = s.length() / amountInUnit;
        if (s.length() % amountInUnit != 0)
            totalUnits++;
 
        // each unit is a rectangle
        int rows = nRows;
        int cols = totalUnits * (nRows - 1);
        char[][] map = new char[rows][cols];
         
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
 
            // which unit, starts from 0
            int unitNumber = i / amountInUnit;
 
            // which postion in the unit, starts from 0
            int posInUnit = i % (amountInUnit);
 
            // if it's in the first column of the unit
            int x, y;
            if (posInUnit < nRows) {
                x = posInUnit;
                y = unitNumber * (nRows - 1);
            } else {
                x = nRows - 1 - (posInUnit + 1 - nRows);
                y = nRows - x - 1 + unitNumber * (nRows - 1);
            }
            map[x][y] = ch;
             
            i++;
             
        } // while
 
        // iterate and output
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j] != 0)
                    sb.append(map[i][j]);
            }
        }
        return sb.toString();
    }
}

//niub
public String convert(String s, int nRows) {
    char[] c = s.toCharArray();
    int len = c.length;
    StringBuffer[] sb = new StringBuffer[nRows];
    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

    int i = 0;
    while (i < len) {
        for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
            sb[idx].append(c[i++]);
        for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
            sb[idx].append(c[i++]);
    }
    for (int idx = 1; idx < sb.length; idx++)
        sb[0].append(sb[idx]);
    return sb[0].toString();
}

