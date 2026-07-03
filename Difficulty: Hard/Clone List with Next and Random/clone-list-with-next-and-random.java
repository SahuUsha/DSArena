/*
class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}
*/
class Solution {
    public Node cloneLinkedList(Node head) {
        
        if(head==null){
            return null;
        }
        
        if(head.next == null){
           Node copy = new Node(head.data);
           copy.random = (head.random == head) ? copy : null;
           return copy;
        }
        
        // code here
        insertNode(head);
        connectRandom(head);
       return  joinNextPointer(head);
        
    }
    
    public void insertNode(Node head){
        
        Node temp = head;
        
        while(temp!=null){
        Node newNode  = new Node(temp.data);
        newNode.next = temp.next;
        temp.next = newNode;
       temp = newNode.next;
            
        }
    }
    
    public void connectRandom(Node head){
        
        Node temp = head;
        
        while(temp!=null){
              if(temp.random != null){
                temp.next.random = temp.random.next;
            }

            
            temp = temp.next.next;
        }
    }
    
    public Node joinNextPointer(Node head){
        
        
        Node dummyList = new Node(-1);
        Node dummy = dummyList;
        
        
        Node temp = head;
        
        while(temp!=null){
            
            Node cloned = temp.next;
            
            temp.next = cloned.next;
            
            dummy.next = cloned;
            dummy = cloned;
            
            if(temp.next!=null){
                cloned.next = temp.next.next;
            }
            
            temp = temp.next;
        }
        
        
        return dummyList.next;
        
    }
}