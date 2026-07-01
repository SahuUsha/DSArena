/*
Definition for Node
class Node{
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    int findMaxSum(Node root) {
        // code here
        int max[] = new int[1];
        max[0] = root.data;
        maxSum(root,max);
        return max[0];
       
    }  
    
    int maxSum(Node root , int max[]){
        if(root==null) return 0;
        
        int left = Math.max(0,maxSum(root.left, max));
        int right =Math.max(0,maxSum(root.right, max));
        
        max[0] = Math.max(max[0], left+right+root.data);
        
        return root.data+ Math.max(left,right);
    }
}