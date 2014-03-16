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
        if (root == null) {
            return true;
        }
        Queue<TreeNode> leftQ = new LinkedList<TreeNode>();
        Queue<TreeNode> rightQ = new LinkedList<TreeNode>();
        leftQ.add(root);
        rightQ.add(root);

        while (!leftQ.isEmpty() && !rightQ.isEmpty()) {
            TreeNode left = leftQ.remove();
            TreeNode right = rightQ.remove();

            if ((left == null && right !=null) || (left != null && right == null)) {
                return false;
            }

            if (left != null && right != null) {
                if (left.val != right.val) {
                    return false;
                }

                leftQ.add(left.left);
                leftQ.add(left.right);
                rightQ.add(right.right);
                rightQ.add(right.left);
            }
        }

        return true;
    }
}
