/*
 *Given a binary tree, determine if it is height-balanced.
 *
 *For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
    public class Result {
        boolean balanced;
        int height;
        Result(boolean b, int h) {
            balanced = b;
            height = h;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalancedHelper(root).balanced;
    }

    public Result isBalancedHelper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Result(true, 1);
        }

        int leftHeight = 0;
        boolean leftBalanced = true;
        int rightHeight = 0;
        boolean rightBalanced = true;

        if (root.left != null) {
            Result leftResult = isBalancedHelper(root.left);
            leftHeight = leftResult.height;
            leftBalanced = leftResult.balanced;
        }
        if (root.right != null) {
            Result rightResult = isBalancedHelper(root.right);
            rightHeight = rightResult.height;
            rightBalanced = rightResult.balanced;
        }

        if (Math.abs(rightHeight-leftHeight) > 1) {
            return new Result(false, 0);
        }

        return new Result(leftBalanced & rightBalanced, Math.max(rightHeight, leftHeight) + 1);
    }
}

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getDepth(root, 0) != -1;
    }
    public int getDepth(TreeNode n, int depth) {
        if (n == null) {
            return depth;
        }
        if (n.left == null && n.right == null) {
            return depth + 1;
        }
        int left = getDepth(n.left, depth+1);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(n.right, depth+1);
        if (right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left, right);
    }
}
