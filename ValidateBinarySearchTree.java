/*
 *Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 *Assume a BST is defined as follows:
 *
 *The left subtree of a node contains only nodes with keys less than the node's key.
 *The right subtree of a node contains only nodes with keys greater than the node's key.
 *Both the left and right subtrees must also be binary search trees.
 *confused what "{1,#,2,3}" means?
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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean isValidBSTRec(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (min < node.val && max > node.val) {
            return isValidBSTRec(node.left, min, node.val) & isValidBSTRec(node.right, node.val, max); 
        }
        return false;
    }
}
