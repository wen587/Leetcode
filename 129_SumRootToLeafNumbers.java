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
//dfs  recursive
public class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    public int helper(TreeNode root, int path) {
        if(root == null) return 0;
        path = path * 10 + root.val;
        if(root.left == null && root.right == null) return path;
        
        int res1 = helper(root.left, path);
        int res2 = helper(root.right, path);
        return res1 + res2;
    }
}
//iterative
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur.right != null) {
                cur.right.val = cur.val * 10 + cur.right.val;
                stack.push(cur.right);
            }
            
            if(cur.left != null) {
                cur.left.val = cur.val * 10 + cur.left.val;
                stack.push(cur.left);
            }
            
            if(cur.left == null && cur.right == null) res += cur.val;
        }
        return res;
    }
}
