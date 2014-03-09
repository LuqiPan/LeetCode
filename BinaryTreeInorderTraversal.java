/*
 *Given a binary tree, return the inorder traversal of its nodes' values.
 *
 *For example:
 *Given binary tree {1,#,2,3},
 *      1
 *       \
 *        2
 *       /
 *      3
 *return [1,3,2].
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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        //s.push(root);

        while (!s.empty() || cur != null) {
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            } else {
                TreeNode n = s.pop();
                result.add(n.val);
                cur = n.right;
            }
        }

        return result;
    }
}
