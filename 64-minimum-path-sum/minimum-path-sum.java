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

        // return tabulation(grid);
    }

    public int minDp(int m, int n, int[][] grid, int[][] dp) {

    if (m == 0 && n == 0) {
        return grid[0][0];
    }

    if (m < 0 || n < 0) {
        return Integer.MAX_VALUE;
    }
    
    if(dp[m][n]!=-1){
        return dp[m][n];
    }

    int up = minDp( m - 1, n,grid,dp);
    int left = minDp(m, n - 1,grid, dp);

    int min = Math.min(up, left);

    if (min == Integer.MAX_VALUE) return min;
    dp[m][n] = grid[m][n]+min;

    return dp[m][n];

    }

    public int tabulation(int grid[][]){
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];

        for(int i =0 ; i<n ; i++){
            for(int j =0 ; j<m ;j++){

                if(i==0 && j==0) dp[i][j] = grid[i][j];

                else{

                    int up =grid[i][j];
                    int left =grid[i][j];
                    if(i>0) {
                        up += dp[i-1][j];
                    }else{
                        up = Integer.MAX_VALUE;
                    }

                    if(j>0){
                        left += dp[i][j-1];
                    }else{
                        left =  Integer.MAX_VALUE;
                    }
                    dp[i][j] = Math.min(up,left);
                }

            }
        } 
      return dp[n-1][m-1];

    }
}
