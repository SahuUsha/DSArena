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
class Pair{
    Node node;
    int ver;
    Pair(Node node, int ver){
        this.node = node;
        this.ver = ver;
    }
}

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair pq = q.poll();
            
            map.put(pq.ver , pq.node.data);
            
            if(pq.node.left!=null){
                q.offer(new Pair(pq.node.left,pq.ver-1));
            }
            
            if(pq.node.right!=null){
                q.offer(new Pair(pq.node.right,pq.ver+1));
            }
            
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int val : map.values()){
            list.add(val);
        }
        
        return list;
        
    }
}