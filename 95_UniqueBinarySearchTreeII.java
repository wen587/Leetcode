// Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

// For example,
// Given n = 3, your program should return all 5 unique BST's shown below.

//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3


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
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    public List<TreeNode> helper(int s, int e) {
        List<TreeNode> res = new ArrayList<>();
        if(s > e) {
            res.add(null);
            return res;
            // return null; //如果直接返回null  下面的l和r会出现null pointer
        }
        for(int i=s; i<=e; i++) {
            List<TreeNode> left = helper(s, i - 1);
            List<TreeNode> right = helper(i + 1, e);
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}