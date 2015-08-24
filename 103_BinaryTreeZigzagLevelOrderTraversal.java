/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' 
 * values. 
 * (ie, from left to right, then right to left for the next level and alternate 
 * between).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//two stack
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> curL = new Stack<>();
        Stack<TreeNode> nextL = new Stack<>();
        Stack<TreeNode> temp;
        
        List<List<Integer>> res new ArrayList<List<Integer>>();
        if(root == null) return res;
        curL.push(root);
        boolean normal = true;
        while(!curL.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while(!curL.isEmpty()) {
                TreeNode node = curL.pop();
                list.add(curL.val);
                if(normal) {
                    if(node.left != null) nextL.push(node.left);
                    if(node.right != null) nextL.push(node.right);
                }else {
                    if(node.right != null) nextL.push(node.right);
                    if(node.left != null) nextL.push(node.left);
                }
            }
            res.add(list);
            temp = curL;
            curL = nextL;
            nextL = temp;
            normal = !normal;
        }
        return res;
    }
}
//这叫啥方法
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        helper(root, res, 0);
        return res;
        
    }
    
    private void helper(TreeNode root, List<List<Integer>> res, int level) {
        if(root == null) return;
        if(res.size() <= level) {
            List<Integer> temp = new ArrayList<>();
            res.add(temp);
        }
        List<Integer> list = res.get(level);
        if(level % 2 == 1) {
            list.add(0, root.val);
        } else {
            list.add(root.val);
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}
