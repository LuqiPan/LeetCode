/*
 *You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 *Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            int result = l1.val + l2.val + carry;
            if (result >= 10) {
                carry = 1;
                result -= 10;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(result);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (carry == 0) {
            if (l1 == null && l2 == null) {
                return dummyHead.next;
            }
            cur.next = (l1 == null) ? l2 : l1;
            return dummyHead.next;
        } else {
            if (l1 == null && l2 == null) {
                cur.next = new ListNode(1);
                return dummyHead.next;
            }
            cur.next = (l1 == null) ? addOne(l2) : addOne(l1);
            return dummyHead.next;
        }
    }

    public ListNode addOne(ListNode l) {
        int carry = 1;
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l != null) {
            int result = l.val + carry;
            if (result >= 10) {
                carry = 1;
                result -= 10;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(result);
            cur = cur.next;
            l = l.next;
        }

        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return dummyHead.next;
    }
}
