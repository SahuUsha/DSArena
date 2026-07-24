class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> triangle) {
        // Code here
        // return pathSum(triangle, 0 , 0 ,0);
        // int n = triangle.size();
        
        return tabulation(triangle);
   
        
        
    }
    public int pathSum(ArrayList<ArrayList<Integer>> triangle,int level,int idx1 , int sum){
        if(level>=triangle.size() ){
            return sum;
        }
        
        
      int notTake = pathSum(triangle,level+1,idx1,sum + triangle.get(level).get(idx1));
      int take = pathSum(triangle, level+1, idx1+1, sum+triangle.get(level).get(idx1));
        
        return Math.min(notTake, take);
        
    }
    
    public int tabulation(ArrayList<ArrayList<Integer>> triangle){
        
           int n = triangle.size();
            
            int dp[] = new int[n];
            
            for(int  i = 0 ; i<triangle.get(n-1).size() ; i++){
                dp[i] =  triangle.get(n-1).get(i);
            }
            
            for(int row = n-2 ;row >=0 ; row--){
                for(int col = 0 ; col<=row ; col++){
                    dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col+1]);
                }
            }
            
            return dp[0];
    }
}