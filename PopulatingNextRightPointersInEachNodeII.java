/*
 *Follow up for problem "Populating Next Right Pointers in Each Node".
 *
 *What if the given tree could be any binary tree? Would your previous solution still work?
 *
 *Note:
 *
 *You may only use constant extra space.
 *For example,
 *    Given the following binary tree,
 *    1
 *   /  \
 *  2    3
 * / \    \
 *4   5    7
 *After calling your function, the tree should look like:
 *    1 -> NULL
 *   /  \
 *  2 -> 3 -> NULL
 * / \    \
 *4-> 5 -> 7 -> NULL
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode cur;
        TreeLinkNode nextHead = root;

        while (nextHead != null) {
            cur = nextHead;
            nextHead = null;
            TreeLinkNode nextCur = null;
            while (cur != null) {
                if (cur.left != null) {
                    if (nextHead == null) {
                        nextHead = cur.left;
                    }
                    if (nextCur == null) {
                        nextCur = cur.left;
                    } else {
                        nextCur.next = cur.left;
                        nextCur = nextCur.next;
                    }
                }
                if (cur.right != null) {
                    if (nextHead == null) {
                        nextHead = cur.right;
                    }
                    if (nextCur == null) {
                        nextCur = cur.right;
                    } else {
                        nextCur.next = cur.right;
                        nextCur = nextCur.next;
                    }
                }
                cur = cur.next;
            }
        }
    }
}
