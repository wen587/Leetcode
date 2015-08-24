// Find coin combination.
// iterative - DP
public class Solution{
	public int countNum(int[] nums, int target) {
		int[][] table = new int[nums.length][target + 1];//正常的习惯
		for(int i = 0; i<nums.length; i++) {
			table[i][0] = 1;
		}
		for(int i=0; i<nums.length; i++) {
			for(int j = 1; j<target + 1; j++) {
				if(j >= nums[i]) {
					table[i][j] = table[i][j - nums[i]] + (i - 1 >= 0 ? table[i - 1][j] : 0);
											//？ 判断弱于加减运算
				} else {
					table[i][j] = table[i - 1][j];
				}
			}
		}
		return table[nums.length -1][target];


		//
		int[][] table = new int[target + 1][nums.length];//按照习惯所以行着来
		for(int j = 0; j<nums.length; j++) {
			table[0][j] = 1;
		}
		for(int i=1; i<target + 1; i++) {
			for(int j=0; j<nums.length; j++) {
				int with = (i - nums[j] >= 0) ? table[i - nums[j]][j] : 0;
				int without = j>=1 ? table[i][j - 1] : 0;
				table[i][j] = with + without;
			}
		}
		return table[target][nums.length - 1];
	}
}
//DP O(target) space 66666
public class Solution{
	public int countNum(int[] nums, int target) {
		int[] table = new int[target + 1];
		table[0] = 1;
		for(int i=0; i<nums.length; i++) {
			for(int j = nums[i]; j<=target; j++) {
				table[j] += table[j - nums[i]];
			}
		}
		return table[target];
		
	}
}

//recursive - duplicate calculation
public class Solution {
	public int countNum(int[] nums, int target) {
		int res = helper(nums, target, nums.length - 1);
		
	}
	private int helper(int[] nums, int target, int index) {

		if(index < 0 || target < 0) return 0;
		if(target = 0) return 1;
		int with = helper(nums, target - nums[index], index);
		int without = helper(nums, target, index - 1);
		return with + without;
	}
}