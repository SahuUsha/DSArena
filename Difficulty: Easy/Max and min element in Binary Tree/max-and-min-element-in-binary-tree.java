/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public static int findMax(Node root) {
    
    int max = Integer.MIN_VALUE;
   
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i<size;i++){
                Node node = q.poll();
                
                max = Math.max(max,node.data);
                
                if(node.left!=null){
                    q.offer(node.left);
                }
                
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
        }
        
       return max; 
        
    }

    public static int findMin(Node root) {
        
        int min = Integer.MAX_VALUE;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i<size;i++){
                Node node = q.poll();
                
                min = Math.min(min,node.data);
                
                if(node.left!=null){
                    q.offer(node.left);
                }
                
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
        }
        
       return min; 
    }
}