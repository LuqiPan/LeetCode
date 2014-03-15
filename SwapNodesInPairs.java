/*
 *Given a linked list, swap every two adjacent nodes and return its head.
 *
 *For example,
 *Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 *Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead; //start at dummy head
        while (p != null && p.next != null && p.next.next != null) {
            ListNode second = p.next.next;
            p.next.next = second.next;
            second.next = p.next;
            p.next = second;
            p = second.next; // update p to be the element just before the next pair
        }
        return dummyHead.next;
    }
}
