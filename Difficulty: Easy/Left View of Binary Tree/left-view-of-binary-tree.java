/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        leftrecur(root,0,list);
        return list;
        
    }
    int maxdepth =-1;
    public void leftrecur(Node root, int level , ArrayList<Integer> list){
        if(root==null) return;
        
        if(maxdepth<level){
            list.add(root.data);
            maxdepth = level;
        }
        
        leftrecur(root.left,level+1,list);
        leftrecur(root.right,level+1,list);
    }
}