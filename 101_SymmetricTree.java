/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric 
 * around its center).
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
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

//recursive
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right) {
        if(left == null || right == null) {
            return left == right;
        }
        if(left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
//Iterative
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
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return true;
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()) {
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if(n1 == null && n2 == null) continue;
            if(n1 == null || n2 == null || n1.val != n2.val) return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }
}