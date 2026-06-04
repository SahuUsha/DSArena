/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    
       public ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
         return preOrder1(root,list);
         
        
        
           
           
       }
    
    public ArrayList<Integer> preOrder1(Node root, ArrayList<Integer> list) {
        //  code here
        if(root==null) return list;
        
        list.add(root.data);
       preOrder1(root.left,list);
        preOrder1(root.right,list);
        
        return list;
        
    }
    
}