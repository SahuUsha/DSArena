class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean visited[] = new boolean[isConnected.length];
        int provinces =0;

        for(int  i = 0; i<isConnected.length ;i++){
            if(!visited[i]){
                provinces++;
                DFS(i,isConnected,visited);
            }
        }

        return provinces;
    }

    public static void DFS(int node, int [][] isConnected , boolean []vis){

        vis[node] = true;

        for(int n = 0 ; n<isConnected.length;n++){
            if(isConnected[node][n]==1 && !vis[n]){
                DFS(n,isConnected,vis);
            }
        }
    }
}