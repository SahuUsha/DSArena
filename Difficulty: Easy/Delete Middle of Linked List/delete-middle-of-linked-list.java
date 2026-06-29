/* Node Structure
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node deleteMid(Node head) {
        
        // code here
        if(head==null || head.next==null){
            return null;
        }
        
        Node first = head;
        Node second = head;
        Node middlePrev = null;
        
        while(second!=null && second.next!=null ){
            middlePrev = first;
            first = first.next;
            second = second.next.next;
        }
        
        if(second==null){

            middlePrev.next = first.next;
             first.next=null;
        }
        else if(second.next==null){
            // System.out.println(middlePrev.data);
            // System.out.println(first.data);
             middlePrev.next = first.next;
             first.next=null;
        }
        
        return head;
    }
}