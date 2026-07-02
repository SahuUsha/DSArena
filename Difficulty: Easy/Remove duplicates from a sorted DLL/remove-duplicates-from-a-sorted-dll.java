/* Structure of a link list node
class Node {
    int data;  // value stored in node
    Node next;
    Node prev;

    Node(int value) {
        data = value;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node headRef) {
        // code here
        if(headRef==null || headRef.next==null){
            return headRef;
        }
        
        Node fp = headRef;
        Node sp = headRef.next;
        
        while(sp!=null){
            
            if( fp.data==sp.data){
                while(sp!=null && fp.data==sp.data){
                    sp = sp.next;
                }
                fp.next = sp;
               if(sp!=null) sp.prev = fp;
            }
            
            fp = fp.next;
          if(sp!=null)  sp = sp.next;
        }
        
        return headRef;
    }
}