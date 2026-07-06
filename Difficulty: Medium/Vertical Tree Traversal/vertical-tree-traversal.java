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
    
    int x;
    int level;
    Node node;
    
    Pair(int x,int level ,Node node){
        this.node = node;
        this.x = x;
        this.level = level;
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // code here
       return verticalTraversal(root);
    }
    
    public static ArrayList<ArrayList<Integer>> verticalTraversal(Node root){
        
        if(root==null){
            return null;
        }
        
        TreeMap<Integer , TreeMap<Integer ,  ArrayList<Integer>>> map = new TreeMap<>();
        
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,root));
        
        
        while(!q.isEmpty()){
            
           
              Pair p = q.poll();
              Node node = p.node;
              int x = p.x;
              int level = p.level;
            
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            
            if(!map.get(x).containsKey(level)){
                map.get(x).put(level,new  ArrayList<Integer>());
            }
            
            map.get(x).get(level).add(node.data);
            
            if(node.left!=null){
                q.offer(new Pair(x-1,level+1,node.left));
            }
            
            if(node.right!=null){
                q.offer(new Pair(x+1,level+1,node.right));
            }
               
           
            
        }
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(TreeMap<Integer ,  ArrayList<Integer>> pt : map.values()){
              list.add(new ArrayList<>());
            for(ArrayList<Integer> yt : pt.values()){
                for(int n : yt){
                    list.get(list.size()-1).add(n);
                }
            }
        }
        
        return list;
    }
}