/**
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //      ListNode vishal = headA;
    //    ListNode vishalGF = headB;

    //    while(vishal !=vishalGF){
    //     if(vishal == null){
    //         vishal = headB;
    //     }
    //     else{
    //         vishal = vishal.next;
    //     }
    //     if(vishalGF == null){
    //         vishalGF = headA;
    //     }else{
    //          vishalGF = vishalGF.next;
    //     }
    // }
    // // return vishal; 
    //     return vishalGF;
    return getInterSect(headA ,headB);
    }

// both code are correct


    public ListNode getInterSect(ListNode headA , ListNode headB){
      ListNode first = headA;
      ListNode second = headB;

      ListNode move1 =  headA ;
      ListNode move2 = headB;

      
      int n1 = 1;
      int n2 = 1;
      while(first.next!=null){
        first = first.next;
        n1++;
      }
      while(second.next!=null){
      second = second.next;
      n2++;
      }
     int diff = Math.abs(n2-n1);

     if(n2>n1){
        for(int i = 0 ; i<diff ; i++){
           move2 = move2.next;
        }
     }else{
        for(int i = 0 ; i<diff ; i++){
           move1 = move1.next;
        }
     }

     while(move1 != move2){
        move1 = move1.next;
        move2 = move2.next;
     }

     return move2;



    }
}