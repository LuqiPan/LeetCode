/*
 *Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

/*
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
    public class ListNodeComparator implements Comparator<ListNode> {
        @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
    }
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        //remember to handle easy edge case
        if (lists.size() == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        ListNodeComparator comparator = new ListNodeComparator();
        PriorityQueue<ListNode> PQ = new PriorityQueue<ListNode>(lists.size(), comparator);
        for (ListNode n: lists) {
            if (n != null) {
                PQ.add(n);
            }
        }
        while (!PQ.isEmpty()) {
            ListNode n = PQ.poll();
            if (n.next != null) {
                PQ.add(n.next);
            }
            p.next = n;
            p = n;
        }
        return dummyHead.next;
    }
}
