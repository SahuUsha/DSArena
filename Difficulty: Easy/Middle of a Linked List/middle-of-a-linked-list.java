/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    int getMiddle(Node head) {
        // code here
        if(head==null) return 0;
        
        Node first = head;
        Node second = head;
        
        while( second.next!=null && second.next.next!=null ){
            first = first.next;
             second = second.next.next;
        }
        
        if(second.next==null){
            
        return first.data;
        
        }else{
            return first.next.data;
        }
        
    }
}