

/* Find the contiguous subarray within an array (containing at least one 
 * number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */ 


public class Solution {
    public int maxSubArray(int[] A) {
        if(A == null) return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++){
            sum += A[i];
            if(max < sum) max = sum;
            if(sum < 0) sum = 0;
        }
        return max;
    }
}

//DP Solution
public class Solution{  
    public int maxSubArray(int[] A) {
            int n = A.length;
            int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
            dp[0] = A[0];
            int max = dp[0];
    
            for(int i = 1; i < n; i++){
                dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
                max = Math.max(max, dp[i]);
            }
    
            return max;
    } 
}

//DP2
public int maxSubArray(int[] A) {
        if(A.length == 0){
            return 0;
        }

        int [] dp = new int[A.length]; 

        int max_sum = A[0];
        dp[0] = A[0];

        for(int i=1; i<A.length; i++){
            dp[i] = Math.max(dp[i-1] + A[i], A[i]);
            max_sum = Math.max(dp[i], max_sum);
        }

        return max_sum;  
    }
