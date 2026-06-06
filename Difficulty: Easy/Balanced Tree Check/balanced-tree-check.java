/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public boolean isBalanced(Node root) {
        // code here
        return balHeight(root)!=-1;
        
    }
    public int balHeight(Node root){
        if(root==null) return 0;
        
        int left = balHeight(root.left);
        if(left==-1) return -1;
        
        int right = balHeight(root.right);
        if(right==-1) return -1;
        
        if(Math.abs(left-right)>1) return -1;
        
        return Math.max(left,right)+1;
        
        
    }
    
    
}