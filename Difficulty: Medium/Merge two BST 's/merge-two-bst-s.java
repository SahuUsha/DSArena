/*
class Node {
    int data;
    Node left, right;

    public Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> merge(Node root1, Node root2) {
        // code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        traversal(root1,list);
        traversal(root2,list);
        
        Collections.sort(list);
        
        return list;
        
    }
    public void traversal(Node root,ArrayList<Integer> list){
        if(root==null) return;
        
        list.add(root.data);
        traversal(root.left,list);
        traversal(root.right,list);
        
    }
}