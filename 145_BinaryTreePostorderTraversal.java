/*
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [3,2,1].
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
    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }
    
    private void traverse(TreeNode node) {
        if(node == null) return;
        traverse(node.left);
        traverse(node.right);
        res.add(node.val);
        
    }
}

//iterative 思路厉害
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Boolean> status = new Stack<Boolean>();
        
        while(!stack.isEmpty() || node!=null) {
            if(node!=null) {
                status.push(true);
                stack.push(node);
                node = node.left;
            } else{
                node = stack.peek();
                boolean flag = status.pop();
                if(flag) {
                    node = node.right;
                    status.push(false);
                } else {
                    res.add(node.val);
                    stack.pop();
                    node = null;
                }
            }
        }
        return res;
    }
}
//Tricky using reverse, modify preoder to root-right-left
public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.left != null)
                stack.push(cur.left);
            if (cur.right != null)
                stack.push(cur.right);
        }
        Collections.reverse(result);
        return result;
    }

