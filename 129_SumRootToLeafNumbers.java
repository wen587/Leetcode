/*
 * Given a binary tree containing digits from 0-9 only, 
 * each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which 
 * represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *    1
 *   / \
 *  2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
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

//开始往下 不是从下往上
public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        if(root.left != null) {
            root.left.val += root.val * 10;
        }
        if(root.right != null) {
            root.right.val += root.val * 10;
        }
        return sumNumbers(root.left) + sumNumbers(root.right);
    }
}

//dfs
public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int sum) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 10 * sum + root.val;
        return dfs(root.left, 10 * sum + root.val) + 
            dfs(root.right, 10 * sum + root.val);
    }