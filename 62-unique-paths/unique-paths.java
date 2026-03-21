class Solution {
    public int uniquePaths(int m, int n) {
        
    //    return uniquePathRecursion(m,n,0,0);

       int [][]dp = new int[m][n];
       for(int []dp1: dp){
        Arrays.fill(dp1,-1);
       }
       return  memoization(m-1,n-1,dp);
    }

     public int uniquePathRecursion(int m,int n, int row, int column) {
        if (row == m || column == n) {
            return  0;
        }
        if (row == m-1 && column == n-1) {
            return 1;
        }
        int sp1 = uniquePathRecursion(m,n, row, column + 1); // Right
        int sp2 = uniquePathRecursion(m,n, row + 1, column); // Down

        return sp1 + sp2;
    }
    public int memoization(int i , int j , int [][]dp){
        if (i<0 || j<0 ) {
            return  0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int sp1 =  memoization(i,j-1,dp); // left
        int sp2 =  memoization(i-1,j,dp); // up

        dp[i][j] = sp1+ sp2;

        return dp[i][j];
    }
}