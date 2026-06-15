/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return Build(preorder , 0 ,preorder.length-1, 0,inorder.length-1,map);
    }
    
    
    public static Node Build(int []preorder, int preStart , int preEnd , int inStart ,
    int inEnd  , HashMap<Integer, Integer> map){
        
        if(preStart>preEnd || inStart>inEnd) return null;
        
        Node root = new Node(preorder[preStart]);
        
        int inRoot = map.get(root.data);
        int numsLeft = inRoot - inStart;
        
        root.left = Build(preorder,preStart +1,preEnd+numsLeft ,inStart,inRoot -1,map);
        
        root.right = Build(preorder,preStart + numsLeft+1,preEnd ,inRoot+1,inEnd,map);
        
        
        return root;
    }
}