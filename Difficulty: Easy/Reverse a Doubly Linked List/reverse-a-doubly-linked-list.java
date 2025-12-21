/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        
        if(head==null || head.next==null){
            return head;
        }
        // code here
        
        Node temp = head;
        Node last = null;
        while(temp!=null){
            last = temp.prev;
            temp.prev = temp.next;
            temp.next = last;
            
            temp = temp.prev;
        }
        
        return last.prev;
        
       
        
    }
}


// method - Swap the link next and prev link