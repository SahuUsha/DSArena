/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            // System.out.println("no cycle")
            return null;

        }

        ListNode hare = head; // fast
        ListNode turtle = head;  // slow
        boolean isCycle = false;
      

        while(hare!=null && hare.next !=null && hare.next.next!=null ){
            hare = hare.next.next;
            turtle = turtle.next;

            if(hare==turtle){
               isCycle = true;
              break; 
            }
        }
        if(isCycle){
            turtle = head;
            while(turtle!=hare){
                turtle=  turtle.next;
                hare = hare.next;
            }
            return hare;

        }else{
            return null;

        }



    }
}