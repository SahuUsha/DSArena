/*
class Node {
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
};
*/

class Solution {
    public int cycleStart(Node head) {
        // code here
        if(head==null || head.next==null){
            return -1;
        }
        
        Set<Node> set = new HashSet<>();
        Node temp = head;
        
        while(temp!=null){
            
            if(set.contains(temp)){
                return temp.data;
            }
             
            set.add(temp);
            temp = temp.next;
            
        }
        
        return -1;
    }
}