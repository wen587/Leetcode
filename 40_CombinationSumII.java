/*
 * Given a collection of candidate numbers (C) and a 
 * target number (T), find all unique combinations in 
 * C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, � , ak) must be in non-descending order. 
 * (ie, a1 ? a2 ? � ? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 */

public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(res, list, num, 0, target);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> list, int[] num, int pos, int target) {
        if(target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=pos; i<=num.length-1 && target>0; i++) {
            if(i > pos && num[i] == num[i-1]) continue;
            list.add(num[i]);
            dfs(res, list, num, i+1, target - num[i]);
            list.remove(list.size()-1);
        }
    }
}