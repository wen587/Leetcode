/*
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest 
 * path from the root node down to the nearest leaf node.
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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
    // public int helper(TreeNode root, int res) {
    //     if(root.left == null && root.right == null) {
    //         return res;
    //     } else {
    //         res += 1;
    //         if(root.right == null) {
    //             return helper(root.left, res);
    //         } else if(root.left == null) {
    //             return helper(root.right, res);
    //         } else {
    //             return Math.min(helper(root.left, res), helper(root.right, res));
    //         }
    //     }
    // }
}
//

public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null || root.right == null) {
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}