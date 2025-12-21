/*
Structure of a Doubly LinkList
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node delPos(Node head, int x) {
        // code here
        
        if(head==null){
            return null;
        }
        
        if(x==1){
            Node temp = head;
            head = head.next;
            
            if(head.prev!=null){
                head.prev = null;
            }
            
            temp.next = null;
            return head;
        }
        
        Node temp = head;
        for (int i = 1; i < x; i++) {
            temp = temp.next;
        }

        
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        // Remove references
        temp.next = null;
        temp.prev = null;

        return head;
    }
}