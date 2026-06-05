/* A binary tree Node
class Node {
    public int data;
    public Node left;
    public Node right;

    // Constructor
    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/

class Solution {
    public ArrayList<Integer> levelOrder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        return LevelOrder1(root,list);
        // code here
        
        
    }
    public ArrayList<Integer> LevelOrder1(Node root, ArrayList<Integer> anslist){
        
        Queue<Node> queue = new LinkedList<>();
        
        
        if(root==null) return anslist;
        
        queue.offer(root);
        
        while(!queue.isEmpty()){
           int size = queue.size();
           List<Integer> sublist = new ArrayList<>();
           for(int i = 0 ; i<size;i++){
               
           if(queue.peek().left!=null) queue.offer(queue.peek().left);
           if(queue.peek().right!=null) queue.offer(queue.peek().right);
           
           sublist.add(queue.poll().data);
           }
           for(int i=0;i<sublist.size();i++){
               anslist.add(sublist.get(i));
           }
            
        }
        return anslist;                                                                                                                                                                                                                                                                                                                                                                                       
    }
}