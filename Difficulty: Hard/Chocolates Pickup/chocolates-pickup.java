class Solution {
    public int maxChocolate(int grid[][]) {
        // code here
        
    int dp[][][] = new int[grid.length][grid[0].length][grid[0].length];
    for(int i = 0 ; i<dp.length ; i++){
        for(int j = 0 ; j<dp[0].length;j++){
            for(int k = 0 ; k<dp[0].length ; k++){
                dp[i][j][k] = -1;
            }
        }
    }
    
    return Chocolate(grid,0,0,grid[0].length-1,dp);
        
    }
    
  public int Chocolate(int[][] grid, int row, int lcol , int rcol, int[][][]dp) {
      
      if(lcol<0 || rcol<0 || lcol>=grid[0].length || rcol>=grid[0].length){
          return Integer.MIN_VALUE;
      }
      
      if(row==grid.length-1){
          if(lcol==rcol) return grid[row][rcol];
          else
          return grid[row][lcol] + grid[row][rcol];
      }
      
      if(dp[row][lcol][rcol]!=-1){
          return dp[row][lcol][rcol];
      }
      
      int []dj = {-1, 0, +1};
      int maxi = Integer.MIN_VALUE;
      for(int dj1 = -1 ; dj1<=1 ; dj1++){
          int value= 0;
          for(int dj2 = -1 ; dj2<=1 ; dj2++){
              if(lcol==rcol){
                  value = grid[row][rcol];
              }else{
                  value = grid[row][lcol] + grid[row][rcol];
              }
              value += Chocolate(grid,row+1,lcol+dj1,rcol+dj2,dp);
              maxi = Math.max(maxi,value);
              
          }
      }
        dp[row][lcol][rcol] = maxi;
      
     return dp[row][lcol][rcol];
  }

    
}