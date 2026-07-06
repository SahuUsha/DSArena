class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(int i= 0 ;i<V;i++){
            list.add(new ArrayList<>());
        }
        
        for(int n[] : edges){
            
            int u = n[0];
            int v = n[1];
            
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        
        boolean visited[] = new boolean[V];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i<V;i++){
            if(!visited[i]){
           ArrayList<Integer> component = new ArrayList<>();
           DFS(V,edges,visited,i,list, component);
           ans.add(component);
            } 
            
        }
        return ans;
        
    }
    public static void DFS(int V, int [][]edges ,boolean vis[],int node, ArrayList<ArrayList<Integer>> list,ArrayList<Integer> component){
        
        vis[node] = true;
        component.add(node);
        
        for(int neighbor :  list.get(node)){
            if(!vis[neighbor]){
                DFS(V,edges,vis,neighbor,list,component);
            }
        }
        
    }
}