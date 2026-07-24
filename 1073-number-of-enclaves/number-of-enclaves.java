class Solution {
    public int numEnclaves(int[][] grid) {

        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int n = grid.length;
        int m = grid[0].length;

        int drow[] = {0,-1,0,1};
        int dcol[] = {1,0,-1,0};

        for(int i = 0; i<m ; i++){
            if(!vis[0][i] && grid[0][i]==1){
                DFS(0,i,vis,drow,dcol,grid);
            }

            if(!vis[n-1][i] && grid[n-1][i]==1){
                DFS(n-1,i, vis,drow, dcol,grid);
            }
        }
        
        for(int j = 0 ; j<n ; j++){
            if(!vis[j][0] && grid[j][0]==1){
                DFS(j , 0 ,vis,drow, dcol,grid);
            }

            if(!vis[j][m-1] && grid[j][m-1]==1){
                DFS(j, m-1 , vis, drow, dcol,grid);
            }
        }

       int cnt = 0;
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(!vis[i][j] && grid[i][j]==1){
                  cnt++;
                }
            }
        }
        
        return cnt;
    }

    public void DFS(int row , int col , boolean [][]vis ,  int[]drow , int []dcol , int[][] grid){
       vis[row][col] = true;

       for(int  i = 0 ; i<4;i++){
        int nrow = row + drow[i];
        int ncol = col + dcol[i];

        if(ncol>=0 && ncol<grid[0].length && nrow>=0 && nrow<grid.length && !vis[nrow][ncol] && grid[nrow][ncol]==1){
            DFS(nrow, ncol , vis, drow, dcol, grid);
        }
       }
    }
}