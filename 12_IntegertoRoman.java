/*
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * I = 1;
 * V = 5;
 * X = 10;
 * L = 50;
 * C = 100;
 * D = 500;
 * M = 1000;
 */
public class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        int enums[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String res = "";
        for(int i=0; i<enums.length; i++) {
            int quotient = num/enums[i];
            num = num%enums[i];
            for(int j=1; j<=quotient; j++) {
                res += map.get(enums[i]);
            }
        }
        return res;
    }
}