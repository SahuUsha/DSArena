class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> triangle ) {
        // Code here
        // return minrec(triangle,0,0);
        
        // int dp[][] = new int[triangle.size()][triangle.size()];
        // for(int []d: dp){
        //     Arrays.fill(d,-1);
        // }
        
        // return memoization(triangle,0,0,dp);
        
        return tabulation(triangle);
        
    } 
    public int minrec(ArrayList<ArrayList<Integer>> triangle  , int idx,int j){
       
          if (idx == triangle.size() - 1) {
        return triangle.get(idx).get(j);
    }

        
      
          int cdown = triangle.get(idx).get(j) + minrec(triangle, idx + 1, j);
          int diag = triangle.get(idx).get(j) + minrec(triangle,idx+1,j+1);
          
             return Math.min(cdown, diag);
        
            
    }
    
    public int memoization(ArrayList<ArrayList<Integer>> triangle  , int idx,int j , int [][]dp){
       
           if (idx == triangle.size() - 1) {
        return triangle.get(idx).get(j);
        }
        
        if(dp[idx][j]!=-1){
            return dp[idx][j];
        }
        
         int cdown = triangle.get(idx).get(j) + minrec(triangle, idx + 1, j);
         int diag = triangle.get(idx).get(j) + minrec(triangle,idx+1,j+1);
          
         dp[idx][j] = Math.min(cdown, diag);
         return dp[idx][j];
            
    }
    public int tabulation(ArrayList<ArrayList<Integer>> triangle){
        int n = triangle.size();
        
        int [][]dp = new int[n][n];
        
        for(int i = 0 ;i<triangle.get(n-1).size();i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        
        for(int i = n-2 ; i>=0 ;i--){
            
            for(int j= i ; j>=0;j--){
    
                int cdown = triangle.get(i).get(j) + dp[i+1][j];
                int up = triangle.get(i).get(j) + dp[i+1][j+1];
            int min = Math.min(cdown,up);
            dp[i][j] = min;
            }
        }
        return dp[0][0];
        
    }
}