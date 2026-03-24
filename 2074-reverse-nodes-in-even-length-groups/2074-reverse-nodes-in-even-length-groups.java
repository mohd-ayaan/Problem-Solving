/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        int groupSize = 1;

        while (head != null) {
            // Step 1: Count actual nodes in this group
            int count = 0;
            ListNode temp = head;
            while (count < groupSize && temp != null) {
                temp = temp.next;
                count++;
            }

            // Step 2: If group length is even, reverse it
            if (count % 2 == 0) {
                prev.next = reverse(head, count);
                prev = head; // after reversal, head becomes tail
            } else {
                // Skip group without reversing
                prev = head;
                for (int i = 1; i < count; i++) {
                    prev = prev.next;
                }
            }

            // Step 3: Move head to next group
            head = prev.next;
            groupSize++;
        }
        return dummy.next;
    }

    // Helper to reverse 'count' nodes starting from 'head'
    private ListNode reverse(ListNode head, int count) {
        ListNode prev = null, curr = head;
        while (count-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = curr; // connect tail to next group
        return prev;      // new head of reversed group
    }
}
