/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
}
}*/

class Solution {
     Node ans = null;
    Node lca(Node root, int n1, int n2) {
        // code here
        
        
       return lca1(root,n1,n2);
       
        
    }
   
    Node lca1(Node root, int n1 , int n2){
        if(root==null || root.data == n1 || root.data==n2) {return root;}
        
       Node l = lca1(root.left,n1,n2);
       Node  r= lca1(root.right,n1,n2);
        
        
        if(l==null){
            return r;
        }else if(r==null){
            return l;
        }else{
            
         return root;
        }
        
    }
    
}