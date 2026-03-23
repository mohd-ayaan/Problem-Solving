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
    public ListNode swapNodes(ListNode head, int k) {
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        if(size==1){return head;}

        ListNode ptr1=head;
        for(int i=1;i<k;i++){
            ptr1=ptr1.next;
        }

        ListNode ptr2=head;
        for(int i=1;i<=size-k;i++){
            ptr2=ptr2.next;
        }

        int val=ptr1.val;
        ptr1.val=ptr2.val;
        ptr2.val=val;

        return head;
    }
}