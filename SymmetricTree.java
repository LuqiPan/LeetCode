/*
 *Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 *For example, this binary tree is symmetric:
 *
 *    1
 *   / \
 *  2   2
 * / \ / \
 *3  4 4  3
 *But the following is not:
 *    1
 *   / \
 *  2   2
 *   \   \
 *    3    3
 *Note:
 *Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    public boolean helper(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 != null && n2 != null) {
            if (n1.val == n2.val) {
                return helper(n1.left, n2.right) & helper(n2.left, n1.right);
            }
        }
        return false;
    }
}
