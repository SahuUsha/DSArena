class Solution {
    public int uniquePaths(int[][] grid) {
        // code here
        
        int [][]dp = new int[grid.length][grid[0].length];
        for(int []dp1: dp){
        Arrays.fill(dp1,-1);
        }
        return  memoization(grid.length-1,grid[0].length-1,dp,grid);
        
    }
     public int memoization(int i , int j , int [][]dp, int[][]grid){
        if (i<0 || j<0 ) {
            return  0;
        }
        if((i >= 0 && j >= 0) && grid[i][j]==1) return 0;
        
        if (i == 0 && j == 0) {
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int sp1 =  memoization(i,j-1,dp,grid); // left
        int sp2 =  memoization(i-1,j,dp,grid); // up

        dp[i][j] = sp1+ sp2;

        return dp[i][j];
    }
};