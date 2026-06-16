/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    
       public ArrayList<Integer> preOrder(Node root) {
        // ArrayList<Integer> list = new ArrayList<>();
        //  return preOrder1(root,list);
        
        return morris(root);
       }
    
    public ArrayList<Integer> preOrder1(Node root, ArrayList<Integer> list) {
        //  code here
        if(root==null) return list;
        
        list.add(root.data);
       preOrder1(root.left,list);
        preOrder1(root.right,list);
        
        return list;
        
    }
    
    // morris method 
    public ArrayList<Integer> morris(Node root){
        ArrayList<Integer> list = new ArrayList<>();
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
                    prev.right=curr;
                    list.add(curr.data);
                    curr = curr.left;
                }else{
                    prev.right=null;
                    curr = curr.right;
                }
                
                
            }
        }
        
        return list;
    }
    
}