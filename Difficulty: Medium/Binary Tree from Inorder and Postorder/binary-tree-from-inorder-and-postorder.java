/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    
    
    
    Node buildTree(int[] inorder, int[] postorder) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0 ;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return Build(postorder,postorder.length-1,0,0,inorder.length-1,map);
    
    }
    
    private static Node Build(int []postorder , int postStart , int postEnd ,
    int inStart , int inEnd, HashMap<Integer,Integer> map){
        
        if(postStart < postEnd || inStart > inEnd) return null;
        
        Node root = new Node(postorder[postStart]);
        
        int inRoot = map.get(root.data);
        
        int numsRight = inEnd - inRoot;
        
        root.right = Build(postorder, postStart - 1, postStart - numsRight,
                   inRoot + 1, inEnd, map);

         root.left = Build(postorder, postStart - numsRight - 1, postEnd,
                  inStart, inRoot - 1, map);
        
        return root;
    }
}