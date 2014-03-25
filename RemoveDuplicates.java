/*
 *Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 *For example,
 *Given 1->1->2, return 1->2.
 *Given 1->1->2->3->3, return 1->2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode cur = head;
        while (p.next != null) {
            if (p.next.val != p.val) {
                cur.next = p.next;
                cur = cur.next;
            }
            p = p.next;
        }
        cur.next = null;
        return head;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode cur = head;

        while (p.next != null) {
            p = p.next;
            if (p.val != cur.val) {
                cur.next = p;
                cur = cur.next;
            }
        }
        cur.next = null;
        return head;
    }
}
