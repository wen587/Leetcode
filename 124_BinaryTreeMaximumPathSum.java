// Given a binary tree, find the maximum path sum.

// The path may start and end at any node in the tree.

// For example:
// Given the below binary tree,

//        1
//       / \
//      2   3
// Return 6.


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
    int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int l = Math.max(0, helper(root.left));
        int r = Math.max(0, helper(root.right));
        res = Math.max(l + r + root.val, res);
        return Math.max(l, r) + root.val;
    }
}

//更6
// Here's my ideas:

// A path from start to end, goes up on the tree for 0 or more steps,
//  then goes down for 0 or more steps. Once it goes down, it can't go up.
//   Each path has a highest node, which is also the lowest common ancestor
//    of all other nodes on the path.
// // A recursive method maxPathDown(TreeNode node) (1) computes the maximum
//  path sum with highest node is the input node, update maximum if n
//  ecessary (2) returns the maximum sum of the path that can be extended
//   to input node's parent.
// Code:

public class Solution {
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}