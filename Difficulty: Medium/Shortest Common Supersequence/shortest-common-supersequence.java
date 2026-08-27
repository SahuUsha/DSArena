class Solution {
    public static int minSuperSeq(String s1, String s2) {
        // code here
        
        int i = s1.length();
        int j  = s2.length();
        
        StringBuilder str = new StringBuilder();
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        
        longestCommonSubsequence(s1,s2,dp);
        
        while(i>0 && j>0){
           if(s1.charAt(i-1)==s2.charAt(j-1)){
               str.append(s1.charAt(i-1));
               i--;
               j--;
           }
           
          else if(dp[i-1][j]>dp[i][j-1]){
               str.append(s1.charAt(i-1));
               i--;
          }else{
              str.append(s2.charAt(j-1));
               j--;
          }
        }
          while(i>0){
              str.append(s1.charAt(i-1)); 
              i--;
          }
          
          while(j>0){
              str.append(s2.charAt(j-1)); 
              j--;
          }
           
       
      String ans = str.reverse().toString();
        
        return ans.length();
        
    }
    
    public static void longestCommonSubsequence(String s1, String s2 ,  int dp[][]){
        
    
        for(int  i = 1 ; i<=s1.length() ; i++){
            for(int  j = 1 ; j<=s2.length() ; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
                }
            }
        }
        
        
        
    }
}
