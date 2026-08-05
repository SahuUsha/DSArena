class Solution {
    public int maximumPoints(int mat[][]) {
        // code here
        // int len = mat.length;
        // return maximumact(mat,len-1,3);
        
        return tabulation(mat);
        
    }
    public int maximumact(int mat[][], int idx , int prev){
        
        if(idx<0){
            return 0;
        }
        
    int max = 0;
        
        for(int i = 0 ; i<3 ;i++){
        
        
            if(prev!=i){
              int take = mat[idx][i] + maximumact(mat,idx-1,i);
              max = Math.max(max,take);
            }
        }
        return max;
    }
    
    public int tabulation(int mat[][]){
        
        int dp[][] = new int[mat.length][4];
        dp[0][0] = Math.max(mat[0][1], mat[0][2]);
          dp[0][1] = Math.max(mat[0][0], mat[0][2]);
            dp[0][2] = Math.max(mat[0][1], mat[0][0]);
              dp[0][3] = Math.max(mat[0][0],
                     Math.max(mat[0][1], mat[0][2]));
       
        
        
        for(int i = 1; i<mat.length;i++){
        
            for(int prev = 0 ;prev<4 ; prev++){
               dp[i][prev] = 0;
                
            for(int j = 0 ; j<3 ; j++){
                
                if(prev!=j){
                    int point = mat[i][j] + dp[i-1][j];
                    dp[i][prev] = Math.max(dp[i][prev], point);
                }
            }
            
            }
        }
        
        return dp[mat.length-1][3];
    }
}