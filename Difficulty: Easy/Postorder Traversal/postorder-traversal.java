/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> postOrder(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        return postOrder1(root,list);
        
    }
    public ArrayList<Integer> postOrder1(Node root, ArrayList<Integer> list) {
        
        if(root==null) return list;
          
         postOrder1(root.left,list);
         postOrder1(root.right,list);
         list.add(root.data);
         
         return list;
    }
}