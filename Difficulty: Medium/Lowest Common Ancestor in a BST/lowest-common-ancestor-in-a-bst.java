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
    public Node LCA(Node root, Node n1, Node n2) {
        // code here
      return Traversal(root,n1,n2);
      
        
    }
    
    private static Node Traversal(Node root,Node n1, Node n2){
        if(root==null || n1.data == root.data || n2.data==root.data){
            return root;
        }
        

        Node left = null;
        Node right = null;
        
        if(n1.data<root.data && n2.data<root.data){
          return  Traversal(root.left,n1,n2);
        }else if(n1.data>root.data && n2.data>root.data){
          return Traversal(root.right,n1,n2);
        }else{
            return root;
        }
        
       
        
    }
}