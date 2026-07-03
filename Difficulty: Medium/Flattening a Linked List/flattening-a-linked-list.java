/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node flatten(Node root) {
        
        if(root==null || root.next==null) return root;
                                                                                               ;
        
        root.next = flatten(root.next);
        
        return Merge(root,root.next);
    
        }
         
        Node Merge(Node h1 , Node h2){
            Node dummy = new Node(-1);
            Node dum = dummy;
            
            while(h1!=null && h2!=null){
                if(h1.data<h2.data){
                    dum.bottom = h1;
                    h1 = h1.bottom;
                    
                }else{
                     dum.bottom = h2;
                    h2 = h2.bottom;
                }
                
                
                dum = dum.bottom;
                dum.next=null;
                
                
            }
            
            if(h1!=null) dum.bottom = h1;
            else dum.bottom = h2;
            
            return dummy.bottom;
        }
                                                                                    
}