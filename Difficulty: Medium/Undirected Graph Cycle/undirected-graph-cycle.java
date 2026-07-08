
class Solution {
    class Pair{
        int node;
        int parent;
        
        Pair(int node,int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    
    public boolean isCycle(int V, int[][] edges) {
        
        
        // Code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int e[] : edges){
            int u  = e[0];
            int v = e[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
       boolean vis[] = new boolean[V];
       for(int i = 0 ;i<V;i++){
           if(!vis[i]){
           if(Detect(i,adj,vis)==true){
               return true;
           }
           }
       }
       return false;
    }
    
    
    public boolean Detect(int start , ArrayList<ArrayList<Integer>> adj, boolean vis[]){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,-1));
        vis[start] = true;
        
        while(!q.isEmpty()){
            Pair pr = q.poll();
            
            int node = pr.node;
            int parents = pr.parent;
            
            for(int negb : adj.get(node)){
                
                if(!vis[negb]){
                    vis[negb] = true;
                    q.add(new Pair(negb,node));
                }
                else if(parents!=negb){
                    return true;
                }
        }
    }
        return false;
}

}