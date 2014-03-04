/*
 *Given a binary tree, find its maximum depth.
 *
 *The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return maxDepthRec(root, 0);
    }

    public int maxDepthRec(TreeNode n, int depth) {
        if (null == n.left && null == n.right) {
            return depth + 1;
        }
        int leftDepth = 0;
        if (n.left != null) {
            leftDepth = maxDepthRec(n.left, depth + 1);
        }
        int rightDepth = 0;
        if (n.right != null) {
            rightDepth = maxDepthRec(n.right, depth + 1);
        }
        return Math.max(leftDepth, rightDepth);
    }
}
