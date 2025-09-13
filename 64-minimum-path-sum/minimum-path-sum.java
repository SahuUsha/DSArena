import java.util.Arrays;

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

   
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return minDp(n - 1, m - 1, grid, dp);
    }

    public int minDp(int i, int j, int[][] grid, int[][] dp) {
   
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (i < 0 || j < 0) return Integer.MAX_VALUE;

    
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

       
        if (i > 0) {
            up = grid[i][j] + minDp(i - 1, j, grid, dp);
        }
        if (j > 0) {
            left = grid[i][j] + minDp(i, j - 1, grid, dp);
        }

        return dp[i][j] = Math.min(up, left);
    }

    public int tabulation(int grid[][]){
        int n = grid.length;
        int m = grid.length;
        int dp[][] = new int[n][m];

        for(int i =0 ; i<n ; i++){
            for(int j =0 ; j<m ;j++){

                if(i==0 && j==0) dp[i][j] = grid[i][j];

                else{

                    int up =0;
                    int left =0;
                    if(i>0) {
                        up = grid[i][j] + dp[i-1][j];
                    }

                    if(j>0){
                        left = grid[i][j] + dp[i-1][j];
                    }


                    dp[i][j] = Math.min(up,left);
                }

            }
        } 
      return dp[n-1][m-1];

    }
}
