/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node addOne(Node head) {
        if(head==null ) return head;
        // code here.
        Node temp = head;
        
        Node reverseHead = reverse(temp);
        Node rtemp = reverseHead;
        
        int value = rtemp.data+1;
        
        if(value>=10){
            rtemp.data = value%10;
            int carry = value/10;
            
            Node prev = rtemp;
            rtemp = rtemp.next;
            
            while(rtemp!=null && carry!=0){
                 prev = rtemp;
                int invalue = rtemp.data+carry;
                if(invalue>=10){
                     rtemp.data = invalue%10;
                     carry = invalue/10;
                }else{
                    rtemp.data = invalue;
                    carry =0;
                }
                
                rtemp = rtemp.next;
            }
            
            if (carry != 0) {
        prev.next = new Node(carry);
           } 
            
        }else{
            rtemp.data = value;
        }
        
        Node dreverse = reverse(reverseHead);
        
        // temp.data = temp.data+1;
        
        return dreverse;
    }
    
    public Node reverse(Node head){
        
        Node prev = null;
        Node temp = head;
        
        while(temp!=null){
            Node nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
            
        }
        
        head = prev;
        
        return prev;
    }
}