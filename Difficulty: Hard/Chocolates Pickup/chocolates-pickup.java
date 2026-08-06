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
        
        return  maxChocolate(grid,0,0,grid[0].length-1,dp);
      
    }
    
    public int maxChocolate(int grid[][] , int row , int left, int right, int [][][]dp){
        if(left< 0 || right<0 || right>=grid[row].length || left >=grid[row].length){
            return Integer.MIN_VALUE;
        }
        if(row==grid.length-1){
            if(left==right){
                return grid[row][left];
            }else{
                return grid[row][left] + grid[row][right];
            }
        }
        
        if(dp[row][left][right]!=-1){
            return dp[row][left][right];
        }
        
         int max = Integer.MIN_VALUE;
        for(int i  = -1 ; i<=1 ; i++){
            int value = 0;
            for(int j = -1; j<=1 ; j++){
                if(left==right){
                    value = grid[row][left];
                }else{
                    value = grid[row][left] + grid[row][right];
                }
                value += maxChocolate(grid,row+1,left+i,right+j,dp);
                
        max= Math.max(max ,value);
            }
            
            dp[row][left][right] = max;
        }
        
        return   dp[row][left][right] ;
    }
    
    
}