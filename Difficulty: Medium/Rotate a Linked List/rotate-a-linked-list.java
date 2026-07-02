/*
class Node {
    int data;
    Node next;

    Node(int d){
        data=d;
        next=null;
   }
}
*/

class Solution {
    public Node rotate(Node head, int k) {
        // code here
        if(head==null || head.next==null) return head;
        
        Node last = head;
        int len  = 1;
        Node temp = head;
        
        while(last.next!=null){
            last = last.next;
            len +=1;
        }
        
        int rotate = k%len;
        
        if (rotate == 0) return head;
        
        for(int i = 1 ;i<rotate ;i++){
            
            temp = temp.next;
        }
        
        Node next = temp.next;
        last.next = head;
        head = next;
        temp.next=null;
        
        
        return head;
        
    }
}