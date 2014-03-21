/*
 *Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 *For example:
 *Given the below binary tree and sum = 22,
 *      5
 *     / \
 *    4   8
 *   /   / \
 *  11  13  4
 * /  \    / \
 *7    2  5   1
 *return
 *[
 *  [5,4,11,2],
 *  [5,8,4,5]
 *]
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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        helper(root, sum, new ArrayList<Integer>(), result);
        return result;
    }
    public void helper(TreeNode n, int sum, ArrayList<Integer> trace, ArrayList<ArrayList<Integer>> result) {
        if (n == null) {
            return;
        }
        trace.add(n.val);
        if (n.left == null && n.right == null) {
            if (sum == n.val) {
                result.add(new ArrayList<Integer>(trace));
            }
        } else {
            helper(n.left, sum-n.val, trace, result);
            helper(n.right, sum-n.val, trace, result);
        }
        trace.remove(trace.size()-1);
    }
}
