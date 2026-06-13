class Solution {

    public int countNodes(Node root) {
        // code here
        if(root==null) return 0;
        
        
        return 1+countNodes(root.left) + countNodes(root.right);
    }
}