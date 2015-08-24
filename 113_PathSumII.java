/*
 * Given a binary tree and a sum, find all root-to-leaf 
 * paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        helper(res, list, root, sum);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        
        if(root == null) return;
        list.add(root.val);
        if(sum == root.val && root.left == null && root.right == null) {
            res.add(new ArrayList(list));
            // list.remove(list.size() - 1);
            // return;
        } else {
            helper(res, list, root.left, sum - root.val);
            helper(res, list, root.right, sum - root.val);
        }
        list.remove(list.size() - 1);
    }
}