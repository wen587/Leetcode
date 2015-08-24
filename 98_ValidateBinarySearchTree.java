/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's 
 * key.
 * The right subtree of a node contains only nodes with keys greater than the 
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * OJ's Binary Tree Serialization:
 * The serialization of a binary tree follows a level order traversal, where '#' 
 * signifies 
 * a path terminator where no node exists below.
 * Here's an example:
 *    1
 *   / \
 *  2   3
 *     /
 *    4
 *     \
 *      5
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}". 
 */

//Inorder 666 iterative
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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.pop();
                if(pre != null && cur.val <= pre.val) return false;
                pre = cur;
                root = cur.right;
            }
        }
        return true;
    }
   
}
//inorder recursive
public class Solution {
    Stack<Integer> stack = new Stack<>();
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        Integer pre = null;// 使用Integer作为null 省了一个判断root 为null的句子
        while(!stack.isEmpty()) {
            Integer cur = stack.pop();
            if(pre != null && cur <= pre) return false;
            pre = cur;
        }
        return true;
    }
    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.right);
        stack.add(root.val);
        inorder(root.left);
    }
}

//dfs
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    private boolean helper(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        // if(!helper(root.left, min, root.val) || !helper(root.right, root.val, max)) return false;
        // return true;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
