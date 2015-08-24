// Given a complete binary tree, count the number of nodes.

// Definition of a complete binary tree from Wikipedia:
// In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int hl = 0, hr = 0;
        TreeNode l = root;
        TreeNode r = root;
        while(l != null) {
            hl++;
            l = l.left;
        }
        while(r != null) {
            hr++;
            r = r.right;
        }
        if(hr == hl) return (1 << hr) - 1;//位移更省时
        // if(hr == hl) return (int)Math.pow(2, hr) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}