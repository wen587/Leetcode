// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

// For example, 
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

//best two pointer
public int trap(int[] height) {
        int res = 0;
        int lMax = 0;
        int rMax = 0;
        int l = 0;
        int r = height.length - 1;
        while(l <= r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            if(lMax < rMax) {
                res += lMax - height[l++];
            } else {
                res += rMax - height[r--];
            }
        }
        return res;
    }
//Stack 666
    public class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int i=0; 
        int res = 0;
        int cur = 0;
        while(i < height.length) {
            if(stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            } else {
                int temp = stack.pop();
                cur = stack.isEmpty() ? 0 : 
                (Math.min(height[stack.peek()], height[i]) - height[temp]) * (i - stack.peek() - 1);
                res += cur;
            }
        }
        return res;
    }
}

//silly space consumed 
public class Solution {
    public int trap(int[] height) {
        if(height.length <= 1) return 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[height.length - 1] = height[height.length - 1];
        for(int i=1; i<height.length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        for(int j=height.length - 2; j>=0; j--) {
            right[j] = Math.max(height[j], right[j + 1]);
        }
        int sum = 0;
        for(int i=0; i<height.length; i++) {
            sum += Math.min(right[i], left[i]) - height[i];
        }
        return sum;
    }
}