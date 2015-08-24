/*
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more 
 * than 1. 
 */
// Below is a representation of the tree input: {1,2,2,3,3,3,3,4,4,4,4,4,4,#,#,5,5}:

//         ____1____
//        /         \
//       2           2
//      /  \        / \
//     3    3      3   3
//    /\    /\    /\
//   4  4  4  4  4  4 
//  /\
// 5  5
// Let's start with the root node (1). As you can see, left subtree's depth is 5, while right subtree's depth is 4. Therefore, the condition for a height-balanced binary tree holds for the root node. We continue the same comparison recursively for both left and right subtree, and we conclude that this is indeed a balanced binary tree.
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//dfs
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(helper(root.left) - helper(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int helper(TreeNode root) {
        if(root == null) return 0;
        return Math.max(helper(root.left), helper(root.right)) + 1;
    }
}

//O(n)

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }
    
    int dfsHeight(TreeNode node) {
        if(node == null) return 0;
        int dfsLeft = dfsHeight(node.left);
        if(dfsLeft == -1) return -1;
        int dfsRight = dfsHeight(node.right);
        if(dfsRight == -1) return -1;
        if(Math.abs(dfsHeight(node.left) - dfsHeight(node.right)) > 1) return -1;
        return 1 + Math.max(dfsLeft, dfsRight);
    }
}