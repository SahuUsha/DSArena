/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public boolean detectLoop(Node head) {
        // code here
        if(head==null || head.next==null || head.next.next==null){
            return false;
        }else if(head.next==head){
            return true;
        }else if( head.next!=null && head == head.next.next){
            return true;
        }
        
        
        Node first = head;
        Node second = head.next.next;
        while(first!=null && second.next!=null && second.next.next!=null  ){
            
            if(first==second){
                return true;
            }
            
            first = first.next;
            second = second.next.next;
        }
        
        return false;
    }
}