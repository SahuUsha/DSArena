class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        if(str1.equals(str2)){
            return str1;
        }


          int dp[][] = new int[str1.length()+1][str2.length()+2];
        StringBuilder ans  = new StringBuilder();

        int idx = longestCommonSequence(str1,str2,dp);
        int i = str1.length();
        int j = str2.length();
      

        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                ans.append(str1.charAt(i-1));
                i--;
            }else{
                ans.append(str2.charAt(j-1));
                j--;
            }
        }

        while(i>0){
            ans.append(str1.charAt(i-1));
            i--;
        }

        while(j>0){
            ans.append(str2.charAt(j-1));
            j--;
        }

 

        return ans.reverse().toString();

    }

     public int longestCommonSequence(String s1, String s2, int[][]dp){
      

        for(int i = 0 ; i<s2.length();i++){
            dp[0][i] = 0;
        }

        for(int  j = 0 ; j<s1.length();j++){
            dp[j][0]= 0;

        }

        for(int i = 1;i<=s1.length();i++){
            for(int j = 1 ; j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] =1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    } 
}