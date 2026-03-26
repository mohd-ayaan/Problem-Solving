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
    public ListNode findKth(ListNode temp, int k) {
        while (k-- > 0 && temp != null) {
            temp = temp.next;
        }
        return temp;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextnode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextnode;
        }
        return prev; // return new head
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode kth = findKth(temp, k - 1);
            if (kth == null) {
                if (prev != null) {
                    prev.next = temp;
                }
                break;
            }

            ListNode nextnode = kth.next;
            kth.next = null;

            // reverse current segment
            ListNode newHead = reverse(temp);

            if (temp == head) {
                head = newHead;
            } else {
                prev.next = newHead;
            }

            prev = temp; // temp is now the tail of reversed segment
            temp = nextnode;
        }
        return head;
    }
}
