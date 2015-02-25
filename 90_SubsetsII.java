/*
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
//bit manipln