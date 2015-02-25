/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric 
 * around its center).
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
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
    public boolean isSymmetric(TreeNode root) {
        return root == null || resHelper(root.left, root.right);
    }
    
    private boolean resHelper(TreeNode tree1, TreeNode tree2) {
        return (tree1 ==null && tree2 == null || tree1 != null && tree2 != null && tree1.val == tree2.val 
        && resHelper(tree1.left, tree2.right) && resHelper(tree1.right, tree2.left));
    }
}

//Iterative
//https://oj.leetcode.com/discuss/22288/two-simple-accepted-java-solutions-recursion-and-iteration
//https://github.com/mitcc/AlgoSolutions/blob/master/leetcode/SymmetricTree.java
