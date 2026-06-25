class Solution {
    public int numberOfPaths(int m, int n) {
        // code here
        
        // return Paths(m,n,0,0);
        
        int dp[][] = new int[m][n];
        
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        
        
        return Paths(m,n,0,0,dp);
        
    }
    
    public int Paths(int m , int n ,  int ridx , int cidx, int [][]dp){
        if(ridx>=m || cidx>=n){
            return 0;
        }
        
        if(ridx==m-1 && cidx==n-1){
            return 1;
        }
        
        if(dp[ridx][cidx]!=-1){
            return dp[ridx][cidx];
        }
        
        int row = Paths(m,n,ridx+1,cidx,dp);
        int col = Paths(m,n,ridx,cidx+1,dp);
        
        dp[ridx][cidx] = row+col;
        return dp[ridx][cidx];
    }
}