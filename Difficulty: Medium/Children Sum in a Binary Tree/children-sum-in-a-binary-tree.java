/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        return isSum(root);
        
    }
    public boolean isSum(Node root){
        if(root==null) return true;
        
       if(root.left==null && root.right==null) return true;
       
       
       boolean ans =false;
       
       if(root.left==null){
           ans = root.right.data==root.data;
       }else if(root.right==null){
           ans = root.left.data == root.data;
       }else{
           ans = (root.left.data+root.right.data) == root.data;
       }
        
        boolean L = isSum(root.left);
        boolean R = isSum(root.right);
        
        
        return L && R && ans;
    }
}