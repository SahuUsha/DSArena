class Solution {
    public int maximumPoints(int mat[][]) {
        // code here
    //     int [][]dp = new int[mat.length][4];
    //     for(int[]row : dp){
    //         Arrays.fill(row,-1);
    //     }
        
    //   return  memoization(mat, dp, mat.length-1,3);
       
       return tabulation(mat);
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
    
    public int tabulation(int mat[][]){
        int dp[][] = new int[mat.length][4];
        
        dp[0][0] = Math.max(mat[0][1], mat[0][2]);
        dp[0][1] = Math.max(mat[0][0], mat[0][2]); 
        dp[0][2] = Math.max(mat[0][1] , mat[0][0]);
        dp[0][3] = Math.max(mat[0][0] , Math.max(mat[0][2],mat[0][1]));
        
        for(int day = 1 ; day<mat.length;day++){
            for(int last = 0 ; last<4 ; last++){
                dp[day][last] = 0;
                for(int task = 0; task<3 ;task++){
                    if(task!=last){
                    int point = mat[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }
        
        return dp[mat.length-1][3];
    }
    
    
}