/*
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a 
 * constant space solution?
 * confused what "{1,#,2,3}" means? > read more on how binary tree is 
 * serialized on OJ.

两个错误节点是相邻的，比如：0,1,2,3,5,4,6，这种情况中序遍历的整个过程只能发现一
次异常节点，在这里是4，这种情况，需要把异常节点和它前面那个节点调换，即4和5调换；

两个错误节点不相邻，比如：0,1,5,3,4,2,6，这种情况中序遍历的整个过程可以发现两次
异常节点，在这里分别为3和2，这种情况下，需要把第一个异常节点的前面那个节点和第二
个异常节点调换，即5和2。

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
public class Solution {
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        inorderTraversal(root, list);
        TreeNode first = null;
        TreeNode second = null;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).val < list.get(i - 1).val) {
                if (first == null)
                    first = list.get(i - 1);
                second = list.get(i);
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    public void inorderTraversal(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null)
            return;
        inorderTraversal(root.left, list);
        list.add(root);
        inorderTraversal(root.right, list);
    }
}