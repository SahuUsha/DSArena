/* Structure of Doubly Linked List
class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // code here
        
        if(head==null) return head;
        
        
        Node temp = head;
        while(temp!=null){
            
            if(temp.data==x){
                
                if(temp.prev==null){
                    head = temp.next;
                } 
                
                Node prev = (temp.prev!=null) ? temp.prev : null;
                
                Node next = (temp.next!=null)? temp.next : null;
                if(prev!=null) prev.next = next;
                if(next!=null) next.prev = prev;
                // temp.prev=null;
                // temp.next=null;
                temp = next;
                continue;
            }
            temp = temp.next;
        }
        return head;
    }
}