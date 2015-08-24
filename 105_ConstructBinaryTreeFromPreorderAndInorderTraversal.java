/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int[] inorder, int prePos, int preEnd, int inPos, int inEnd) {
        if(inPos > inEnd || prePos > preEnd) return null;
        TreeNode cur = new TreeNode(preorder[prePos]);
        int index = 0;
        for(int i = inPos; i<= inEnd; i++) {
            if(inorder[i] == cur.val) {
                index = i;
                break;
            }
        }
        cur.left = helper(preorder, inorder, prePos + 1, prePos + index - inPos, inPos, index - 1);
        cur.right = helper(preorder, inorder, prePos + index - inPos + 1, preEnd, index + 1, inEnd);
        return cur;
    }
}




//
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
     
    private TreeNode buildTree(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart>pend)
            return null;
             
        for (int i=istart; i<=iend; i++) {
            if (inorder[i]==preorder[pstart]) {
                TreeNode root = new TreeNode(inorder[i]);
                root.left = buildTree(preorder, pstart+1, pstart+1+(i-1-istart), inorder, istart, i-1);
                root.right = buildTree(preorder, pend-(iend-i-1), pend, inorder, i+1, iend);
                 
                return root;
            }
        }
         
        return null;
    }
}