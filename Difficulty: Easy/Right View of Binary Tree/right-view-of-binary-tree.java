/*
Definition for Node
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
class Pair{
    Node node;
    int level;
    Pair(Node node , int level){
        this.node = node;
        this.level = level;
    }
}


class Solution {
    public ArrayList<Integer> rightView(Node root) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair pq = q.poll();
            
            map.put(pq.level, pq.node.data);
            
            if(pq.node.left!=null){
                q.offer(new Pair(pq.node.left,pq.level+1));
            }
            
            if(pq.node.right!=null){
                q.offer(new Pair(pq.node.right,pq.level+1));
            }
            
        }
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int m : map.values()){
            list.add(m);
        }
        
        return list;
    }
}