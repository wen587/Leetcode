/*
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * I = 1;
 * V = 5;
 * X = 10;
 * L = 50;
 * C = 100;
 * D = 500;
 * M = 1000;
 *
 * the numeral I can be placed before V and X to make 4 units (IV) and 9 units 
 * (IX respectively)
 * X can be placed before L and C to make 40 (XL) and 90 (XC respectively)
 * C can be placed before D and M to make 400 (CD) and 900 (CM) according to 
 * the same pattern
 */
//faster than map
public class Solution {
    public int romanToInt(String s) {
        char[] chrr = s.toCharArray();
        int res = 0;
        int i = 0;
        for(i=0; i<chrr.length - 1; i++) {
            res += chToInt(chrr[i]);
            if(chToInt(chrr[i]) < chToInt(chrr[i+1])) {
                res -= 2 * chToInt(chrr[i]);
            }
        }
        res += chToInt(chrr[i]);
        return res;
    }
    private int chToInt(char c) {
            switch (c) {
                case 'I':   return 1;
                case 'V':   return 5;
                case 'X':   return 10;
                case 'L':   return 50;
                case 'C':   return 100;
                case 'D':   return 500;
                case 'M':   return 1000;
                default:    return 0;
            }
    };
}
//
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] chrr = s.toCharArray();
        int res = 0;
        int i = 0;
        for(i=0; i<chrr.length - 1; i++) {
            res += map.get(chrr[i]);
            if(map.get(chrr[i]) < map.get(chrr[i+1])) {
                res -= 2 * map.get(chrr[i]);
            }
        }
        res += map.get(chrr[i]);
        return res;
    }
}
///

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = map.get(s.charAt(s.length()-1));
        for(int i=s.length()-2; i>=0; i--) {
            result+= (map.get(s.charAt(i))<map.get(s.charAt(i+1)) ? -1 : 1)*map.get(s.charAt(i));
        }
        return result;
    }
}