class Solution {
    public int maxChocolate(int grid[][]) {
        // code here
        
        
        // return max(grid,0,0,grid[0].length-1);
        // int dp[][]
        
        return maxTable(grid);
    }
    
    public int max(int [][]grid, int row , int left, int right){
        
        if(left<0 || left>=grid[0].length || right<0 || right>=grid[0].length){
            return 0;
        }
        
        if(row==grid.length-1){
            
            if(left==right){
                return grid[row][left];
            }else{
                return grid[row][left] + grid[row][right];
            }
            
        }
        
        int lchoc =0,  bchoc =0, rchoc =0;
        
        for(int i = -1 ; i <=1;i++){
          lchoc = Math.max(lchoc, max(grid,row+1,left-1,right+i));
        bchoc = Math.max(bchoc,max(grid,row+1,left,right+i));
        rchoc = Math.max(rchoc,max(grid,row+1,left+1, right+i));
        
        }
        
        if(left==right){
             return grid[row][left] + Math.max(lchoc , Math.max(bchoc, rchoc));
        }else{
            
       return grid[row][left] + grid[row][right] + Math.max(lchoc , Math.max(bchoc, rchoc));
            
            
        }
    }
  
    public int maxTable(int [][]grid){
        
        int dp[][][] = new int[grid.length][grid[0].length][grid[0].length];
        int n = grid.length;
        
        
        for(int left = 0 ; left<grid[0].length ; left++){
            for(int right = grid[0].length-1 ; right>=0 ; right--){
                
                if(left==right){
                    dp[n-1][left][right] = grid[n-1][left];
                }else{
                    
                    dp[n-1][left][right] = grid[n-1][left] + grid[n-1][right];
                }
            }
        }
        
        for(int  i = n-2 ; i>=0 ; i--){
        for(int left = 0 ; left<grid[0].length; left++){
            for(int right = grid[0].length-1 ; right>=0 ; right--){
                
                int max = 0;
                for(int dl = -1; dl<=1;dl++){
                    for(int rl = -1 ; rl<=1 ; rl++){
                        
                        int newleft = left + dl;
                        int newright = right + rl;
                        
                        
                        if(newleft>=0 && newleft<grid[0].length && newright>=0  && newright<grid[0].length){
                            
                            max = Math.max(max, dp[i+1][newleft][newright]);
                        }
                        
                        
                        
                        
                    }
                }
                        
                        if( left==right ){
                            dp[i][left][right] =  grid[i][right] + max;
                        }else{
                            dp[i][left][right] = max + grid[i][left] + grid[i][right];
                        }
            }
        }
        }
        
        // int result = 0;
        // for(int left = 0 ; left<grid[0].length ; left++){
        //     for(int right =  ; right<grid[0].length ;right++){
        //         result = Math.max(result, dp[0][left][right]);
        //     }
        // }
        
        // return result;
        
        return dp[0][0][grid[0].length - 1];
        
    }
    
    // public int Choclate(int grid[][]){
        
        
    // }
}