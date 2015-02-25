    /*
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,2,3].
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
//recursive
public class Solution {
    ArrayList<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        
        traverse(root);
        return res;
        
    }
    private void traverse(TreeNode node) {
        if(node == null) return;
        res.add(node.val);
        traverse(node.left);
        traverse(node.right);
    }
}

//iterative   如果是空root怎么计算呢
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if(temp!=null) {
                res.add(temp.val);
                if(temp.right!=null) stack.push(temp.right);
                if(temp.left!=null) stack.push(temp.left);
            }
        }
        return res;
        
    }
}

//iterative2
public ArrayList<Integer> preorderTraversal_2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                res.add(root.val);
                if(root.right != null)
                    stack.push(root.right);
                root = root.left;
            }
            else
                root = stack.pop();
        }
        return res;
    }
