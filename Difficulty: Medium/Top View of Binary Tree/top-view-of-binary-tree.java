/*
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
class Tuple{
    Node node;
    int ver;
    int level;
    public Tuple(Node node , int ver , int level){
        this.node = node;
        this.ver = ver;
        this.level = level;
    }
}

class Solution {
        TreeMap<Integer , TreeMap<Integer,Integer>> map = new TreeMap<>();
    public ArrayList<Integer> topView(Node root) {
        // code here
        // Queue<Tuple> q = new LinkedList<>();
        
        // q.offer(new TreeNode(root,0,0));
        InOrder(new Tuple(root,0,0));
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(TreeMap<Integer,Integer> ts : map.values()){
            for(int n : ts.values()){
                list.add(n);
            }
            
        }
        
        return list;
    }
    public void InOrder(Tuple tuple){
        
       Tuple p = tuple;
        
        if(p.node==null) return;
        
        InOrder(new Tuple(p.node.left,p.ver-1,p.level+1));
        
        if(!map.containsKey(p.ver)){
                map.put(p.ver , new TreeMap<>());
                
                if(!map.get(p.ver).containsKey(p.level)){
                    map.get(p.ver).put(p.level, p.node.data);
                }
                
                
            }else{
                 TreeMap<Integer,Integer> inner = map.get(p.ver);

             if (inner.firstKey() > p.level) {
                 
  inner.clear(); // remove old level -> value pair
        inner.put(p.level, p.node.data);
                   }
            }
        
        InOrder(new Tuple(p.node.right,p.ver+1,p.level+1));
    }
}