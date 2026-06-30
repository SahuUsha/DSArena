/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        Node list1 = head1;
        Node list2 = head2;
        
        
        while(true){
            if(list1==null){
                list1=head2;
            }
            
            if(list2==null){
                list2 = head1;
            }
            
            if(list1==list2){
                return list1;
            }
            
            list1 = list1.next;
            list2 = list2.next;
        }
        

    }
}