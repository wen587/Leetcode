/*
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 */
//dp recursive
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        res.add(list);
        return helper(res, nums, 0);
        
        
    }
    public List<List<Integer>> helper(List<List<Integer>> res, int[] nums, int i) {
        if(i == nums.length) return res;
        List<List<Integer>> newRes = new ArrayList<List<Integer>>();
        for(List<Integer> l : res) {
            newRes.add(l);
            List<Integer> temp = new ArrayList<>(l);
            temp.add(nums[i]);
            newRes.add(temp);
        }
        return helper(newRes, nums, i+1);
    }
}
//dp iterative
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        res.add(list);
        for(int i=0; i<nums.length; i++) {
            int k = res.size();
            for(int j=0; j<k; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }
}


//dfs
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length < 1) return res;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        helper(res, list, nums, 0);
        
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int pos) {
        res.add(new ArrayList<Integer>(list));
        for(int i=pos; i<nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

