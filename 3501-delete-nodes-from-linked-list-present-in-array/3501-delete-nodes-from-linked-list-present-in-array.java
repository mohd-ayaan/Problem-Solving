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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numset=new HashSet<>();
        for(Integer ele:nums){
            numset.add(ele);
        }

        ListNode dummy=new ListNode(0);
        dummy.next=head; 
        ListNode prev=dummy;
        ListNode curr=head; 
        while(curr!=null){
            if(numset.contains(curr.val)){
                prev.next=curr.next;
            }
            else{
                prev=curr;
            }
            curr=curr.next;
        }
        return dummy.next;

    }
}