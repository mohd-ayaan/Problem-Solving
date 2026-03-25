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
    public ListNode oddEvenList(ListNode head) {
        ListNode curr = head;
        int n = 0;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        if (n < 3) {
            return head;
        }

        ListNode prev = head;
        ListNode even = head.next;
        curr = head.next;
        ListNode nextnode;
        while (curr != null && curr.next != null) {
            nextnode = curr.next;
            System.out.println(prev.val + "->" + nextnode.val);
            prev.next = nextnode;
            prev = curr;
            curr = nextnode;
        }

        if (n % 2 != 0) {
            prev.next = null;
            if (curr != null) {
                curr.next = even;
            }
        } else {
            prev.next = even;
        }
        return head;
    }
}