class Solution {
    public int maximumPoints(int mat[][]) {
        // code here
        int [][]dp = new int[mat.length][4];
        for(int[]row : dp){
            Arrays.fill(row,-1);
        }
        
       return  memoization(mat, dp, mat.length-1,3);
    }
    
    // day == index
    public int memoization(int mat[][], int dp[][] , int day , int last){
        
        if(day==0){
            int max = Integer.MIN_VALUE;
         for(int i = 0 ; i<mat[0].length ;i++){
             if(i!=last)
              max = Math.max(max,mat[day][i]);
         }
         return max;
        }
        
        if(dp[day][last]!=-1){
            return dp[day][last];
        }
        
        int max = Integer.MIN_VALUE;
        for(int i =0 ;i<mat[0].length;i++){
            if(i!=last){
            int point = mat[day][i] + memoization(mat,dp,day-1,i);
                max = Math.max(max,point);
            }
            
        }
        return dp[day][last] = max;
    }
    
}