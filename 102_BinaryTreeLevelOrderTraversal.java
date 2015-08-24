/*
 * Given a binary tree, return the level order traversal of its 
 * nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ] 
 /**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //dfs
 public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, root, 0);
        return res;
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
//bfs using queue
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            res.add(list);
        }
        return res;
    }
}


//bfs using list

 public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<TreeNode> cur = new ArrayList<TreeNode>();
        if(root != null) cur.add(root);
        while(!cur.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            List<TreeNode> next = new ArrayList<TreeNode>();
            for(TreeNode node : cur) {
                list.add(node.val);
                if(node.left != null) next.add(node.left);  
                if(node.right != null) next.add(node.right);
            }
            res.add(list);
            cur = next;
        }
        return res;
    }
}


//Queue

        public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        if (root != null)
            cur.offer(root);
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        while (!cur.isEmpty()) {
            TreeNode node = cur.poll();
            list.add(node.val);
            if (node.left != null)
                next.offer(node.left);
            if (node.right != null)
                next.offer(node.right);
            if (cur.isEmpty()) {
                result.add(list);
                list = new ArrayList<Integer>();
                cur = next;
                next = new LinkedList<TreeNode>();
            }
        }
        return result;
    }