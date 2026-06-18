/* Structure of a Tree Node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
};
*/

class Solution {
    public Node delNode(Node root, int x) {
        // code here
        if(root==null){
            return root;
        }
        
        if(root.data == x){
            Node curr = root;
            if(root.left==null){
                return curr.right;
            }else if(root.right==null){
                return curr.left;
            }else{
                Node prev = curr.left;
                while(prev.right!=null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                return curr.left;
            }
            
        }
        
        if(root.data<x){
            root.right = delNode(root.right,x);
        }else{
            root.left = delNode(root.left,x);
        }
        
        return root;
    }
}