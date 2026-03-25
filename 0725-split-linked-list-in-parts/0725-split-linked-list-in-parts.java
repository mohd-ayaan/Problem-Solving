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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        ListNode[] res = new ListNode[k];
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        temp = head;
        int partSize = n / k;
        int remainder = n % k;

        for (int i = 0; i < k; i++) {
            res[i] = temp;
            int currentSize = partSize + (i < remainder ? 1 : 0);

            for (int j = 0; j < currentSize - 1 && temp != null; j++) {
                temp = temp.next;
            }

            if (temp != null) {
                ListNode next = temp.next;
                temp.next = null;
                temp = next;
            }

        }
        return res;
    }
}