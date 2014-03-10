/*
 *Given a binary tree, return the postorder traversal of its nodes' values.
 *
 *For example:
 *Given binary tree {1,#,2,3},
 *      1
 *       \
 *        2
 *       /
 *      3
 *return [3,2,1].
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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode prev = null;
        while (!s.empty()) {
            TreeNode cur = s.peek();

            if (prev == null || prev.left == cur || prev.right == cur) {
                if (cur.left != null) {
                    s.push(cur.left);
                } else if (cur.right != null) {
                    s.push(cur.right);
                } else {
                    s.pop();
                    result.add(cur.val);
                }
            } else if (cur.left == prev) {
                if (cur.right != null) {
                    s.push(cur.right);
                } else {
                    s.pop();
                    result.add(cur.val);
                }
            } else if (cur.right == prev) {
                s.pop();
                result.add(cur.val);
            }

            prev = cur;
        }

        return result;
    }
}
