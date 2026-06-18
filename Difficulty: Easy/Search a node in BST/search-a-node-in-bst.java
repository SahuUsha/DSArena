/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public boolean search(Node root, int key) {
        // code here
        if(root==null){
            return false;
        }
        
        if(root.data == key){
            return true;
        }
        
        boolean l = false;
        boolean r = false;
        
        if(root.data>key){
           l =  search(root.left,key);
        }
        
        else if(root.data<key){
            r = search(root.right,key);
        }
        
        return l || r;
    }
}