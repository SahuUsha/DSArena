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
        
        return merge(head);
        
    }    
    public Node sortLLBubble(Node head) {
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
    
    public static Node middle(Node head){
        Node slow = head;
        Node fast = head.next;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = slow.next.next;
        }
        
        return slow;
    }
    
    public static Node merge(Node head){
        if(head==null || head.next==null){
            return head;
        }
        
        Node middle = middle(head);
        Node right = middle.next;
        middle.next = null;
        Node left = head;
        
        
        Node lmerge =  merge(left);
       Node rmerge =  merge(right);
        
        return mergeSort(lmerge,rmerge);
    }
    
    public static Node  mergeSort(Node left,Node right){
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(left!=null && right!=null){
            
            if(left.data<right.data){
                temp.next = left;
                temp = left;
                left = left.next;
            }else{
                temp.next= right;
                temp = right;
                right = right.next;
            }
        }
        
        if(left!=null){
            temp.next = left;
        }else{
            temp.next = right;
        }
        
        return dummy.next;
    }
}