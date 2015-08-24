/*
 * Given a set of candidate numbers (C) and a target number (T), find all unique 
 * combinations in C where
 * the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, � , ak) must be in non-descending order. 
 * (ie, a1 ? a2 ? � ? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 */


//bt
public class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, list, target, nums, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int target, int[] nums, int pos) {
        if(target <= 0) {
            if(target == 0) {
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for(int i=pos; i<nums.length; i++) {
            int newTarget = target - nums[i];
            list.add(nums[i]);
            helper(res, list, newTarget, nums, i);
            list.remove(list.size() - 1);
        }
        
    }
}