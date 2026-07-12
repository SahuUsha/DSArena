class Solution {
    public int longestPalindromeSubseq(String s) {

        StringBuilder str = new StringBuilder(s);

        str = str.reverse();

        return longestPalindromsubqLen(s,str.toString());
    }

    public int longestPalindromsubqLen(String s1, String rs2){
        int dp[][] = new int[s1.length()+1][rs2.length()+2];

        for(int i = 0 ; i<s1.length();i++){
            dp[0][i] = 0;
            dp[i][0]= 0;
        }

        for(int i = 1;i<=s1.length();i++){
            for(int j = 1 ; j<=rs2.length();j++){
                if(s1.charAt(i-1)==rs2.charAt(j-1)){
                    dp[i][j] =1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[s1.length()][rs2.length()];
    } 
}