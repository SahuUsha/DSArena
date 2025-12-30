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
    public boolean hasCycle(ListNode head) {
        
        //   if(head==null){
        //     return false;
        //    }

        // ListNode hare = head; // fast
        // ListNode turtle = head;  // slow

        // while(hare!=null && hare.next !=null){
            
        //     hare = hare.next.next;
        //     turtle = turtle.next;

        //     if(hare==turtle){
        //        return true; 
        //     }
        // }
        //     return false;

        return hasCycleprac(head);

    }

    public static boolean hasCycleprac(ListNode head){
        if(head==null){
            return false;
           }

       ListNode first = head;
        ListNode second = head.next;

        while(second!=null && second.next!=null){
            first = first.next;
            second = second.next.next;

            if(first==second){
                return true;
            }
        }

        return false;
    }
}