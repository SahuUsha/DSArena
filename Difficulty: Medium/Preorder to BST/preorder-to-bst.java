/* class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {

    // Function that constructs BST from its preorder traversal.
    public Node preToBST(int pre[]) {
        // code here
        Node root = new Node(pre[0]);
        
        for(int i=1 ; i<pre.length ;i++){
            Node newNode = new Node(pre[i]);
            Node prev =null;
            Node temp = root;
            while(temp!=null){
                
                prev = temp;
                if(pre[i]<temp.data){
                    temp = temp.left;
                }else{
                    temp = temp.right;
                }
                
            }
            
            if(pre[i]<prev.data){
                prev.left = newNode;
            }else{
                prev.right = newNode;
            }
        }
        
        return root;
    }
}