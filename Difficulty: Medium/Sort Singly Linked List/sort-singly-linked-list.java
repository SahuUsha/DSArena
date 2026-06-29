/* Structure of a Linked List Node
class Node
{
    int data;
    Node next;
    Node(int d) {
       data = d;
       next = null;
    }
}*/
class Solution {
    public Node sortLL(Node head) {
        // code here
         if (head == null || head.next == null)
            return head;
        
        int len = 0;
        
        Node temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        
        
        for(int  i =0 ; i<len-1;i++){
     
        Node move = head;
            for(int  j =0 ; j<len-i-1 ;j++){
                if(move.data>move.next.data){
                    int t = move.data;
                    move.data = move.next.data;
                    move.next.data = t;
                }
            move = move.next;
            }
        } 
        
        return head;
        
    }
}