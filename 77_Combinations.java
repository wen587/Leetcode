// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

// For example,
// If n = 4 and k = 2, a solution is:

// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]


//bt
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        helper(res, list, k, n, 1);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int pos) {
        if(list.size() == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=pos; i<=n; i++) {
            list.add(i);
            helper(res, list, k, n, i + 1);
            list.remove(list.size() - 1);
        }
    }
}