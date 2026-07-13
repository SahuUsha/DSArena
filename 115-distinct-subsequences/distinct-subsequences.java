class Solution {
    public int numDistinct(String s, String t) {

        // return DistinctSub(s,t,t.length()-1,s.length()-1);
        // int dp[][] = new int[s.length()][t.length()];
        // for(int []d : dp){
        //     Arrays.fill(d,-1);
        // }
        // return DistinctSub(s,t,t.length()-1,s.length()-1,dp);

        return tabulation(s,t);
    }

    public int DistinctSub(String s, String t , int idxt, int idxs, int dp[][]){
        if(idxt<0){
            return 1;
        }
        if(idxs<0){
            return 0;
        }

        if(dp[idxs][idxt]!=-1){
            return dp[idxs][idxt];
        }
      
       int ans =0;

        if(s.charAt(idxs)==t.charAt(idxt)){
          ans = DistinctSub(s,t,idxt-1,idxs-1,dp) +  DistinctSub(s,t,idxt,idxs-1,dp) ;
        }else{
            ans = DistinctSub(s,t,idxt,idxs-1,dp);
        }
        return dp[idxs][idxt]=ans;
    }

    public int tabulation(String s, String t){

    int dp[][] = new int[s.length()+1][t.length()+1];

    for(int i = 0 ;i<=s.length();i++){
        dp[i][0] = 1;              // idxt < 0  => 1 ==> means a non-empty t cannot be formed from an empty s.
    }

    for(int j = 1 ; j<=t.length();j++){
        dp[0][j] = 0;  // idxs < 0 && idxt >= 0 => 0 ==>means a non-empty t cannot be formed from an empty s.
    }   

    for(int i = 1 ;i<=s.length() ; i++){
        for(int j=1; j<=t.length() ;j++){
            int ans =0;
            if(s.charAt(i-1)==t.charAt(j-1)){
          ans = dp[i-1][j-1] +  dp[i-1][j] ;
        }else{
            ans = dp[i-1][j] ;
        }
        dp[i][j] = ans;
        }
    }
    return dp[s.length()][t.length()];
    }
}