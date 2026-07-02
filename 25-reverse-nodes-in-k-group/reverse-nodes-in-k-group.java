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
    public ListNode reverseKGroup(ListNode head, int k) {
      
      if(head==null || k==1) return head;

        ListNode DummyNode = new ListNode(-1);
        ListNode dummy = DummyNode;

        ListNode temp = head;
        int count = 1;

        while(temp!=null){
            ListNode next =  temp.next;

            if(count==k){
                ListNode tail = temp;
                temp.next = null;

                ListNode rhead = reverse(head);

                dummy.next = rhead;
                head.next = next;

                dummy = head;
                head = next;

                count = 0 ;
            }
           
           temp = next;
           count++;
        }
             
         dummy.next = head;
 
        return DummyNode.next;
    }

     public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode temp = head;
        
        while(temp!=null){
            ListNode next  = temp.next;
            temp.next=prev;
            prev=temp;
            temp = next;
        }
        
        head= prev;
        return head;
    }
}