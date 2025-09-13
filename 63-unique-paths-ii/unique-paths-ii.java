class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n= obstacleGrid[0].length;


        int dp[][] = new int[m][n];

    //     for(int i = 0 ; i<m ;i++){
    //         Arrays.fill(dp[i],-1);
    //     }
    
    //    return mazememo(m-1,n-1,obstacleGrid, dp );

    return tabulation(obstacleGrid);

    
        
    }
    public int mazememo(int i, int j, int [][] obstacleGRid , int dp[][]){
          

        if(i<0 || j<0){
            return  0;
        }

        if((i>=0 && j>=0 ) && obstacleGRid[i][j] ==1){
            return 0;
        }

        if(i==0 && j==0){
            return 1;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int up = mazememo(i-1,j,obstacleGRid,dp );
        int left = mazememo(i,j-1, obstacleGRid, dp);

         dp[i][j] = up+left;

         return dp[i][j];
    }

    public int tabulation( int[][] obstacleGrid){
            int m = obstacleGrid.length;
         int n= obstacleGrid[0].length;

         int dp[][] = new int[m][n];
         for(int i =0; i<m; i++){
            for(int j =0 ; j<n ; j++){

                if((i==0 && j==0) && obstacleGrid[i][j] != 1 ) dp[i][j] = 1;
                else{

                    int left =0;
                    int up =0;

                    if(obstacleGrid[i][j]==1){
                        dp[i][j] = 0;
                        continue;
                    }

                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];

                     dp[i][j] = up + left;

                }

            }
         }

         return dp[m-1][n-1];

    }





}