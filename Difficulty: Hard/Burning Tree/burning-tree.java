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
    Node tar =null;
    
    public void parentsTrack(Node root , Map<Node, Node> parents_track,int target){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node node = q.poll();
            
            if(node.data==target){
                tar = node;
            }

            if(node.left!=null){
                parents_track.put(node.left,node);
                q.offer(node.left);
            }
            
            if(node.right!=null){
                parents_track.put(node.right,node);
                q.offer(node.right);
            }
        }
        
    }
    
    
    public int minTime(Node root, int target) {
        // code here
        Map<Node,Node> parents_track = new HashMap<>();
        Map<Node,Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        parentsTrack(root,parents_track,target);
        
        q.offer(tar);
        visited.put(tar,true);
        int time =0;
        while(!q.isEmpty()){
            int size= q.size();
            time++;
            for(int i = 0 ; i<size ;i++){
                Node node = q.poll();
                visited.put(node,true);
                
            
            if(node.left!=null && visited.get(node.left)==null){
                visited.put(node.left,true);
                q.offer(node.left);
            }
            
            if(node.right!=null && visited.get(node.right)==null){
                visited.put(node.right,true);
                q.offer(node.right);
            }
            if(parents_track.get(node)!=null && visited.get(parents_track.get(node))==null){
                    visited.put(parents_track.get(node),true);
                    q.offer(parents_track.get(node));
                } 
         
            }
            
        }
        return time-1;
        
    }
}