/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a 
 * height balanced BST.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        List<TreeNode> list = new ArrayList<TreeNode>();
        ListNode node = head;
        while(node != null) {
            TreeNode n = new TreeNode(node.val);
            list.add(n);
            node = node.next;
        }
        return helper(list, 0, list.size() - 1);
    }
    
    
    private TreeNode helper(List<TreeNode> list, int start, int end) {
        int mid = (start + end) / 2;
        if(start > end) return null;
        TreeNode root = list.get(mid);
        root.left = helper(list, start, mid - 1);
        root.right = helper(list, mid + 1, end);
        return root;
        
    }
}