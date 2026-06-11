/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    public boolean isSymmetric(Node root) {
        // code here
        Stack<Integer> st = new Stack<>();
        leftSymmetric(root,st);
        rightSymmetric(root,st);
        if(st.size()==0) return true;
        
        return false;
        
        
    }
    public void leftSymmetric(Node root,Stack<Integer> st){
        if(root==null) return;
        
        
        leftSymmetric(root.left,st);
        st.push(root.data);
        leftSymmetric(root.right,st);
            
    }
    public void rightSymmetric(Node root,Stack<Integer> st){
        if(root==null) return;
        
        rightSymmetric(root.left,st);
        if(!st.isEmpty() && st.peek()==root.data){
        st.pop();
        }
        rightSymmetric(root.right,st);
    }
}