// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// For example:
// Given the following binary tree,
//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
// You should return [1, 3, 4].
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//smart
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }
    public void helper(List<Integer> res, TreeNode root, int level) {
        if(root == null) return;
        if(level == res.size()) {
            res.add(root.val);
        }
        helper(res, root.right, level + 1);
        helper(res, root.left, level + 1);
    }
}




//modification of zigzag

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, root, 0);
        List<Integer> list  = new ArrayList<>();
        for(int i=0; i<res.size(); i++) {
            List<Integer> temp = res.get(i);
            int cur = temp.get(temp.size() - 1);
            list.add(cur);
        }
        return list;
    }
    public void helper(List<List<Integer>> res, TreeNode root, int level) {
        if(root == null) return;
        if(res.size() <= level) {
            res.add(new ArrayList<Integer>());
        }
        List<Integer> list = res.get(level);
        list.add(root.val);
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }
}