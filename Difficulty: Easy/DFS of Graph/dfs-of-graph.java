class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean visited[] = new boolean[adj.size()];
        
        DFS(0,adj,ans,visited);
        return ans;
    }
    
    public static void DFS(int node ,ArrayList<ArrayList<Integer>> adj, 
    ArrayList<Integer> ans, boolean []vis){
        
        vis[node] = true;
        ans.add(node);
        
        
        for(int n: adj.get(node)){
            if(!vis[n]){
                DFS(n,adj,ans,vis);
            }
        }
    }
}

