/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can 
 * you climb to the top?
 */
//dp O(n) space
public class Solution {
    public int climbStairs(int n) {
        if(n < 2) return n;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

//dp O(1) space
public class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        if(n==0 || n==1) return 1;
        int res = 0;
        for(int i=2; i<=n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
