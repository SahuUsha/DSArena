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
    Node reverseList(Node head) {
        // code here
        Node temp = head;
        Node prev = null;
        while(temp!=null){
            Node next = temp.next;
            temp.next = prev;
            prev =temp;
            temp = next;
        }
        
        head = prev;
        return prev;
    }
}