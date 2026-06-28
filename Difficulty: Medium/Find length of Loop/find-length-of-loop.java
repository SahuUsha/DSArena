/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        if(head==null || head.next==null){
            return 0;
        }
        
        HashMap<Node,Integer> map = new HashMap<>();
        Node temp = head;
        int lastIdx=0;
        
        while(temp!=null){
            
            if(map.containsKey(temp)){
                return lastIdx - map.get(temp);
            }
            
            map.put(temp,lastIdx++);
            temp = temp.next;
        }
        
        return 0 ;
        
        
    }
}