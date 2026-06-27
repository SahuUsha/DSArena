/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
};
*/

class Solution {
    public ArrayList<Integer> inOrder(Node root) {
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
                    prev.right=curr;
                    curr = curr.left;
                }else{
                    prev.right=null;
                    list.add(curr.data);
                    curr = curr.right;
                }
            } 
        }
         
        return list;
    }
}