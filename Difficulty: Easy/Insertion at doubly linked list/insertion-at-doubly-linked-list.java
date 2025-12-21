/*
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/

class Solution {
    Node insertAtPos(Node head, int p, int x) {
        // code here
        Node newNode = new Node(x);
        Node temp = head;
        for(int i =0 ;i<p;i++){
            temp = temp.next;
        }
        
        newNode.next = temp.next;
        if( temp.next!=null){
            temp.next.prev = newNode;
        }
        
        temp.next = newNode;
        newNode.prev = temp;
        
        return head;
        
    }
}