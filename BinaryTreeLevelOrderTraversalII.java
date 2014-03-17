/*
 *Only changed one line of code
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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
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
                result.add(0, currentLevel);
                currentLevel = new ArrayList<Integer>();
            }
        }
        return result;
    }
}
