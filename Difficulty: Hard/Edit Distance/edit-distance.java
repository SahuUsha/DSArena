class Solution {
    public int editDistance(String s1, String s2) {
        // code here
        
        int [][]dp = new int[s2.length()+1][s1.length()+1];
        
        for(int i = 0 ;i<=s1.length(); i++){
            dp[0][i] = i;
        }
        
        for(int j =0;j<=s2.length();j++){
            dp[j][0] = j;
        }
        
        for(int i=1; i<=s2.length();i++){
            for(int j =1; j<=s1.length(); j++){
                if(s2.charAt(i-1)== s1.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j] , Math.min(dp[i][j-1], dp[i-1][j-1])
                    );
                }
            }
        }
        
        return dp[s2.length()][s1.length()];
    }
}