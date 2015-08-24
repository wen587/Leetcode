/*
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous 
 * solution still work?
 * Note:
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 * 
 */
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */



//iterative
public class Solution {
    public void connect(TreeLinkNode root) {
        helper(root);
    }
    public void helper(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode nextLevel;
        TreeLinkNode pre;
        TreeLinkNode parent = root;
        while(parent != null) {
            pre = null;
            nextLevel = null;
            while(parent != null) {
                if(nextLevel == null) {
                    nextLevel = parent.left == null ? parent.right : parent.left;
                }
                if(parent.left != null) {
                    if(pre != null) {
                        pre.next = parent.left;
                        pre = pre.next;
                    } else {
                        pre = parent.left;
                    }
                }
                if(parent.right != null) {
                    if(pre != null) {
                        pre.next = parent.right;
                        pre = pre.next;
                    } else {
                        pre = parent.right;
                    }
                }
                parent = parent.next;
            }
            parent = nextLevel;
        }
        
    }
}
//
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode level = root;
        while(level != null) {
            TreeLinkNode n = level;
            TreeLinkNode fake = new TreeLinkNode(0);
            TreeLinkNode child = fake;
            while(n != null) {
                if(n.left != null) {
                    child.next = n.left;
                    child = child.next;
                }
                if(n.right != null) {
                    child.next = n.right;
                    child = child.next;
                }
                n = n.next;
            }
            
            child.next = null;
            level = fake.next;
        }
    }
}


