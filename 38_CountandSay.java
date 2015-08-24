/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 */

//recursive
public class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String s = countAndSay(n - 1);
        String res = "";
        int cnt = 1;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) != s.charAt(i - 1)) {
                res += "" + cnt + s.charAt(i - 1);
                cnt = 1;
            } else cnt++;
        }
        res +=  "" + cnt + s.charAt(s.length() - 1);//why "+=" not work, but "= res +" works
                                            //cuz cnt int type, result s.charAt to int.
        return res;
    }
}

//iterative
public class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for(int i=1; i<n; i++) {
            String pre = res;
            res = "";
            int cnt = 1;
            char ch = pre.charAt(0);
            for(int j=1; j<pre.length(); j++) {
                if(pre.charAt(j) != ch) {
                    res = res + cnt + ch;
                    cnt = 1;
                    ch = pre.charAt(j);
                } else cnt++;
            }
            res = res + cnt + ch;
        }
        return res;
    }
}