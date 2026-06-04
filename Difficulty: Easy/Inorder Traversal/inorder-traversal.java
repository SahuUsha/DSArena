/*
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> inOrder(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        return inOrder1(root, list);
        
        
    }
    
    public ArrayList<Integer> inOrder1(Node root, ArrayList<Integer> list){
        
        if(root==null) return list;
        
        inOrder1(root.left,list);
        list.add(root.data);
        inOrder1(root.right,list);
        
        return list;
    }
}