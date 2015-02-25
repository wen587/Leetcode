/*
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more 
 * than 1. 
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
//O(n^2)
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return Math.abs(depth(root.left)-depth(root.right)) <= 1
        && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int depth(TreeNode node) {
        if(node == null) return 0;
        return 1 + Math.max(depth(node.left), depth(node.right));
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