
class Solution {
    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(int  i = 0 ; i<=v;i++){
            list.add(new ArrayList<>());
        }
        
        for(int []ed : edges){
            int u = ed[0];
            int d = ed[1];
            
            list.get(u).add(d);
            list.get(d).add(u);
        }
        
        
        boolean vis[] = new boolean[v+1];
        vis[0] =true;
        int result=0;
        
        
        for(int i = 1;i<=v;i++){
            
            if(!vis[i]){
                
                
                int info[] = new int[2];
                
           
            DFS(edges,list,i,info,vis);
            int vrtx = info[0];
            int edg = info[1];
            
            if((vrtx*(vrtx-1))/2==edg/2){
                result++;
            }
            }
        }
        
        return result;
    }
    
    public static void DFS(int [][]edges,ArrayList<ArrayList<Integer>> list  ,int node ,int []info, boolean vis[])
    {
        
        vis[node] = true;
        
        info[0]++;
        info[1] += list.get(node).size();
        
        for(int ngbr : list.get(node)){
            if(!vis[ngbr]){
                DFS(edges,list,ngbr,info,vis);
            }
        }
    }
}
