/* Structure of doubly linked list node
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
        // code here
        Node headnode = head;
        
        
        
      while(headnode.next!=null){
        Node temp = headnode.next;
        headnode.next = headnode.prev;
        headnode.prev = temp;
        
        headnode = temp;
      }
      headnode.next = headnode.prev;
      headnode.prev = null;
      
      head = headnode;
      return head;
        
    }
}