/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    public int diameter(Node root) {
        // code here
        int []max = new int[1];
        diametric(root,max);
        
        return max[0];
    }
    
    public int diametric(Node root, int []max){
        
        if(root==null){
            return 0;
        }
        
        int lh = diametric(root.left , max);
        int rh  = diametric(root.right, max);
        
        max[0] = Math.max(max[0], lh+rh);
        
        return 1 + Math.max(lh,rh);
    }
}