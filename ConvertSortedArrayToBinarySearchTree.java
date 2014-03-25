/*
 *Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        return toBST(num, 0, num.length-1);
    }

    public TreeNode toBST(int[] num, int start, int end) {
        if (start == end) {
            return new TreeNode(num[start]);
        }
        int mid = (start + end) / 2;
        TreeNode left = null;
        TreeNode right = null;
        if (start < mid) {
            left = toBST(num, start, mid - 1);
        }
        if (end > mid) {
            right = toBST(num, mid + 1, end);
        }
        TreeNode n = new TreeNode(num[mid]);
        n.left = left;
        n.right = right;
        return n;
    }
}
