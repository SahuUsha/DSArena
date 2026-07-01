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
    public Node addTwoLists(Node head1, Node head2) {
        // code here
        if(head1==null && head2 ==null) return null;
        else if(head1==null ||( head1.data==0 && head1.next==null)) return head2;
        else if(head2==null || ( head2.data==0 && head2.next==null) ) return head1;
        
        Node rhead1 = reverse(head1);
        Node rhead2 = reverse(head2);
        
        Node r1temp = rhead1;
        Node r2temp = rhead2;
        
        Node ans = new Node(-1);
        Node temp = ans;
        
        int carry =0;
        
      
        while(r1temp!=null && r2temp!=null){
             
                    //   prev = temp;
                int invalue = r1temp.data + r2temp.data + carry;
                if(invalue>=10){
                     int val = invalue %10;
                     carry = invalue/10;
                     
                      temp.next = new Node(val);
                      temp = temp.next;
                }else{
                    temp.next = new Node(invalue);
                      temp = temp.next;
                      carry =0;
                }
                r1temp = r1temp.next;
                r2temp = r2temp.next;
        }
            
        while(r1temp!=null){
                int invalue = r1temp.data+ carry;
                 if(invalue>=10){
                     int val = invalue %10;
                     carry = invalue/10;
                     
                      temp.next = new Node(val);
                      temp = temp.next;
                }else{
                    temp.next = new Node(invalue);
                      temp = temp.next;
                      carry =0;
                }
                r1temp = r1temp.next;
        }
        
         while(r2temp!=null){
                int invalue = r2temp.data+ carry;
                if(invalue>=10){
                     int val = invalue %10;
                      carry = invalue/10;
                    
                      temp.next = new Node(val);
                      temp = temp.next;
                }else{
                    temp.next = new Node(invalue);
                      temp = temp.next;
                      carry =0;
                }
                r2temp = r2temp.next;
        }
        
        if(carry!=0){
            temp.next = new Node(carry);
            temp = temp.next;
        }
        
        
        Node rfinal = reverse(ans.next);
        
        while(rfinal.data==0){
            rfinal = rfinal.next;
        }
        
        return rfinal;
        
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
        
        
        return prev;
        
    }
}