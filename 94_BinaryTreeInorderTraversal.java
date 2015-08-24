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
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}