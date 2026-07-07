class Solution {
  class Pair{
    int row;
    int col;
    int time;
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
  }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int [][]vis = new int[grid.length][grid[0].length];

        int cntFresh = 0;

        for(int i = 0 ; i<grid.length;i++){
            for(int j =0 ;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                    vis[i][j] =2;
                }else{
                    vis[i][j] =0;
                }
                if(grid[i][j]==1){
                    cntFresh++;
                }
            }
        }

        int cnt = 0;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,+1,0,-1};
        int maxtime = 0;

        while(!q.isEmpty()){
            Pair pr = q.poll();
            for(int i = 0 ; i<4 ;i++){

            int nrow = pr.row+drow[i];
            int ncol = pr.col + dcol[i];
            int time = pr.time;
           maxtime = Math.max(maxtime,time);
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length 
              && vis[nrow][ncol]==0 && grid[nrow][ncol]==1 ){
                q.offer(new Pair(nrow,ncol,time+1));
                vis[nrow][ncol] = 2;
                cnt++;
              }
            }
        }


        if(cnt==cntFresh){
            return maxtime;
        }else{
            return -1;
        }


    }
}