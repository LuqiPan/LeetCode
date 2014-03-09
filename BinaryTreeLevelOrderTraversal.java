/*
 *Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 *For example:
 *Given binary tree {3,9,20,#,#,15,7},
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 *return its level order traversal as:
 *[
 *[3],
 *[9,20],
 *[15,7]
 *]
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int currentCount = 1;
        int nextCount = 0;
        ArrayList<Integer> currentLevel = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            TreeNode n = queue.remove();
            currentLevel.add(n.val);
            currentCount--;

            TreeNode left = n.left;
            TreeNode right = n.right;

            if (left != null) {
                queue.add(left);
                nextCount++;
            }
            if (right != null) {
                queue.add(right);
                nextCount++;
            }

            if (currentCount == 0) {
                currentCount = nextCount;
                nextCount = 0;
                result.add(currentLevel);
                currentLevel = new ArrayList<Integer>();
            }
        }
        return result;
    }
}
