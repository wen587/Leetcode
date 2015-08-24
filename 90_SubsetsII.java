x/*
 * Given a collection of integers that might contain duplicates, S, return all 
 * possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 */
//recursive dp
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=  new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        return helper(res, nums, 0, 0);
    }
    private List<List<Integer>> helper(List<List<Integer>> res, int[] nums, int pos, int oldSize) {
        if(pos == nums.length) return res;
        int k = res.size();

        int start = pos > 0 && nums[pos] == nums[pos - 1] ? oldSize : 0;
        for(int i=start; i<k; i++) {
            List<Integer> list = new ArrayList<Integer>(res.get(i));
            list.add(nums[pos]);
            res.add(list);
        }
        return helper(res, nums, pos + 1, k);
    }
}

//iterative dp
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        int oldSize = 0;
        for(int i=0; i<num.length; i++) {
            int newSize = res.size();
            int start = (i>0 && num[i] == num[i - 1]) ? oldSize : 0;
            for(int j = start; j<newSize; j++) {
                List<Integer> list = new ArrayList<Integer>(res.get(j));
                list.add(num[i]);
                res.add(list);
            }
            oldSize = newSize;
        }
        return res;
    }
}

////dfs
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if(nums.length < 1) return res;
        List<Integer> list = new ArrayList<Integer>();
        helper(res, list, nums, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int pos) {
        res.add(new ArrayList<Integer>(list));
        for(int i=pos; i<nums.length; i++) {
            if(i != pos && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            helper(res, list, nums, i+1);
            list.remove(list.size() - 1);
        }
    }
}
