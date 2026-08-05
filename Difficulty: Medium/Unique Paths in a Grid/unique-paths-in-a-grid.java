class Solution {
    public int uniquePaths(int[][] grid) {
        // code here\
        
        // return unique(grid,grid.length-1,grid[0].length-1);
        return tabulation(grid);
        
    }
    public int unique(int [][]grid, int lt , int tt){
        
        if(lt<0 || tt<0){
            return 0;
        }
        
        if(grid[lt][tt]==1){
            return 0 ;
        }
        if(lt==0 && tt==0){
            return 1;
        }
        
        
     int count  =  unique(grid,lt-1,tt) +   unique(grid,lt,tt-1) ;
     
     return count;
        
    }
    
    public int tabulation(int [][]grid){
        
        
        int dp[][] = new int[grid.length][grid[0].length];
        
        dp[0][0] = 1;
        
        for(int i = 0; i <grid.length ;i++){
            
            for(int j = 0; j<grid[0].length; j++){
                
                
                
                if(grid[i][j]==1){
                    dp[i][j]  = 0;
                    continue;
                }
                
                
                
                if(i==0 && j==0){
                   continue;
                }
                int up = 0;
                int left = 0;
                
                if(i>0){
                    up = dp[i-1][j];
                }
                
                if(j>0){
                    left= dp[i][j-1];
                }
                
                dp[i][j] = up + left;
            }
            
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}