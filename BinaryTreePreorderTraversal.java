/*
 *Given a binary tree, return the preorder traversal of its nodes' values.
 *
 *For example:
 *Given binary tree {1,#,2,3},
 *      1
 *       \
 *        2
 *       /
 *      3
 *return [1,2,3].
 *
 *Note: Recursive solution is trivial, could you do it iteratively?
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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.empty()) {
            TreeNode n = s.pop();
            result.add(n.val);
            if (n.right != null) {
                s.push(n.right);
            }
            if (n.left != null) {
                s.push(n.left);
            }
        }
        return result;
    }
}
