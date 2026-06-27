/*
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> preOrder(Node root) {
        // code here
        
        ArrayList<Integer> list = new ArrayList<>();
        Node curr = root;
        
        while(curr!=null){
            
            if(curr.left==null){
                list.add(curr.data);
                curr = curr.right;
            }else{
                
                Node prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev = prev.right;
                }
                
                if(prev.right==null){
                    prev.right = curr.right;
                    list.add(curr.data);
                    curr = curr.left;
                }else{
                    prev.right = null;
                    curr = curr.right;
                }
                
            }
        }
        return list;
    }
}