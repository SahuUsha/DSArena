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
        // ArrayList<Integer> list = new ArrayList<>();
        // return inOrder1(root, list);
        
        
        return morris(root);
        
    }
    
    public ArrayList<Integer> inOrder1(Node root, ArrayList<Integer> list){
        
        if(root==null) return list;
        
        inOrder1(root.left,list);
        list.add(root.data);
        inOrder1(root.right,list);
        
        return list;
    }
    
    public ArrayList<Integer> morris(Node root){
        ArrayList<Integer> list  = new ArrayList<>();
        Node curr = root;
        
        while(curr!=null){
            
            if(curr.left==null){
                 list.add(curr.data);
                 curr = curr.right;
            }else{

               Node prev = curr.left;
               while(prev.right!=null && prev.right!=curr){
                   prev = prev.right;
               }
               
               if(prev.right==null){
                   prev.right = curr;
                   curr = curr.left;
               }else{
                   prev.right=null;
                   list.add(curr.data);
                   curr = curr.right;  
               }
            }
        }
        
        return list;
    }
} 