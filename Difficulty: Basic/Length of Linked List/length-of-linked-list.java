/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int a){
        data = a;
        next = null;
    }
}
*/
class Solution {
    public int getCount(Node head) {
        // code here
        int length = 0;
        Node temp = head;
        while(temp!=null){
            length++;
            temp =temp.next;
        }
        
        return length;
    }
}