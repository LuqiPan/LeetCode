/*
 *Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head;
        if (p1.val < p2.val) {
            head = p1;
            p1 = p1.next;
        } else {
            head = p2;
            p2 = p2.next;
        }
        ListNode cur = head;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                cur = cur.next;
                p1 = p1.next;
            } else {
                cur.next = p2;
                cur = cur.next;
                p2 = p2.next;
            }
        }

        if (p1 == null) {
            cur.next = p2;
        } else {
            cur.next = p1;
        }

        return head;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode cur = dummyHead;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                cur.next = p2;
                p2 = p2.next;
            } else {
                cur.next = p1;
                p1 = p1.next;
            }
            cur = cur.next;
        }
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
        return dummyHead.next;
    }
}
