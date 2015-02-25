/*
 * Determine whether an integer is a palindrome. Do 
 * this without extra space.
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to 
 * string, note the restriction of using extra space.
 * You could also try reversing an integer. However, 
 * if you have solved the problem "Reverse Integer", 
 * you know that the reversed integer might overflow. 
 * How would you handle such case?
 * There is a more generic way of solving this problem.
 */

//Mine
public class Solution {
    public boolean isPalindrome(int x) {
        ArrayList<Integer> test = new ArrayList<Integer>();
        if(x < 0) return false;
        while(x != 0) {
            int remainder = x % 10;
            test.add(remainder);
            x = x / 10;
        }
        int start = 0;
        int end = test.size() - 1;
        while (start <= end) {
            if(test.get(start) == test.get(end)) {
                start++;
                end--;
            }
            else return false;
        }
        return true;
    }
}

//Smart
 public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int xCopy = x;
        int reverse = 0;
        while (xCopy != 0) {
            reverse = 10 * reverse + xCopy % 10;
            xCopy /= 10;
        }
        return reverse == x;
    }
//another smart
    public boolean isPalindrome(int x) {
        String s = x + "";
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

