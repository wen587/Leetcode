/*
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,3,2].
 * Note: Recursive solution is trivial, could you do it iteratively?
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

//Recursive
public class Solution {
    ArrayList<Integer> res = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }
    
    private void traverse(TreeNode node) {
        if(node==null) return;
        
        traverse(node.left);
        res.add(node.val);
        traverse(node.right);
        
        
    }
}

//iterative
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        
        while(!stack.isEmpty() || node!=null) {
            if(node!=null) {
                stack.push(node);
                node = node.left;
            } else{
                node = stack.pop();
                if(node == null) return res;
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }
}