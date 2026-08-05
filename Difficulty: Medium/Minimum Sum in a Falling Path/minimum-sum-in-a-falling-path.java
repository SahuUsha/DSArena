class Solution {
    public int minFallingPathSum(int[][] mat) {
        // code here
        // int min = Integer.MAX_VALUE;
        // for(int i = 0 ; i<mat[0].length;i++){
        //     min  = Math.min(min, minFallingSum(mat,0,i));
        // }
        // return  min;
        return  tabulation(mat);
    }
    
    public int minFallingSum(int[][] mat, int row , int col){
        
        
        if(col<0 || col>=mat[0].length) return Integer.MAX_VALUE;
        if(row==mat.length-1) return mat[row][col];
        
      int path1 = minFallingSum(mat, row+1,col);
       int path2= minFallingSum(mat,row+1,col-1);
      int path3 = minFallingSum(mat,row+1,col+1);
      
      
      return mat[row][col] + Math.min(path1, Math.min(path2,path3));
      
    }
    
    public int tabulation(int mat[][]){
        int dp[][] = new int[mat.length][mat[0].length];
        
        for(int i = 0 ; i<mat[0].length ; i++){
            dp[0][i] = mat[0][i];
        }
        
        for(int i = 1 ; i<mat.length ; i++){
            
            for(int j =0 ; j<mat[0].length ; j++){
                int ass2 =  Integer.MAX_VALUE;
                int ass3 = Integer.MAX_VALUE;
                
                if(j-1>=0) ass2 = dp[i-1][j-1];
                if(j+1<mat.length) ass3 = dp[i-1][j+1];
                
                dp[i][j] = mat[i][j] + Math.min(dp[i-1][j],Math.min(ass2,ass3));
            }
            
        }
        
        int min =Integer.MAX_VALUE;
        
        for(int i =0 ;i<mat[0].length ; i++){
            min = Math.min(dp[mat.length-1][i], min);
        }
        
        return min;
    }
    
}
