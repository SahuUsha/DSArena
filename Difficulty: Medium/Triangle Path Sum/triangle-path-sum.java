class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> triangle) {
        // Code here
        
        int dp[][] = new int[triangle.size()][triangle.size()];
        
        dp[0][0] = triangle.get(0).get(0);
        
        for(int i = 1; i < triangle.size(); i++) {
            for(int j = 0; j <= i; j++) {
                
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }
                
                else if(j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }
                
                else {
                    dp[i][j] = triangle.get(i).get(j) 
                             + Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < triangle.size(); i++) {
            result = Math.min(result, dp[triangle.size()-1][i]);
        }
        
        return result;
    }
}