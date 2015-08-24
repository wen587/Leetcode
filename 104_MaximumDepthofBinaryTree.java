    /*
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the 
 * root node down to the farthest leaf node.
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
//
public class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }
    public int helper(TreeNode root, int res) {
        if(root == null) return res;
        // if(root.left == null) return 1 + helper(root.right, res);
        // if(root.right == null) return 1 + helper(root.left, res);
        return Math.max(helper(root.left, res), helper(root.right, res)) + 1;
    }
}
//

 public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}