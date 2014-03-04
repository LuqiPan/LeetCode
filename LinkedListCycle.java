/*
 *Given a linked list, determine if it has a cycle in it.
 *
 *Follow up:
 *Can you solve it without using extra space?
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }
        ListNode p = head;
        ListNode runner = head;

        while (runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            p = p.next;
            if (runner == p) {
                return true;
            }
        }
        return false;
    }
}
