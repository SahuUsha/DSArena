/*
Definition for Node
class Node {
    int data;
    Node left, right;
    Node(int d)
    {
        data  =d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
        Deque<Node> q = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        int level =1;
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            for(int i =0 ; i<size;i++){
                if(level%2!=0){
                    Node last = q.pollLast();
                    list.add(last.data);
                    
                    if(last.left!=null){
                        q.addFirst(last.left);
                    }
                    
                    if(last.right!=null){
                        q.addFirst(last.right);
                    }
                    
                }else{
                      Node front = q.pollFirst();
                    list.add(front.data);
                
                    if(front.right!=null){
                        q.addLast(front.right);
                    }
                    
                    if(front.left!=null){
                        q.addLast(front.left);
                    }
                }
            }
            level++;
        }
        return list;
    }
}