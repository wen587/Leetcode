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

public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // List<Integer> list = new ArrayList<Integer>();
        res.add(new ArrayList<Integer>());
        for(int i=0; i<S.length; i++) {
            int k = res.size();
            for(int j=0; j<k; j++) {
                //强烈注意要new 一个ArrayList表示
                List<Integer> list = new ArrayList<Integer>(res.get(j));
                list.add(S[i]);
                res.add(list);
            }
        }
        return res;
    }
}

//bit manipulation