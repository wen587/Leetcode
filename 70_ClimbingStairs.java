/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can 
 * you climb to the top?
 */
//recursive
public class Solution {
    public int climbStairs(int n) {
        if(n==0) return 0;
        int[] a = new int[n+2];
        a[1] = 1;
        a[2] = 2;
        for(int i=3; i<=n; i++) {
            a[i] = a[i-1] + a[i-2];
        }
        return a[n];
    }
}

//数学归纳
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
