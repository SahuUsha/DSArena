class Solution {
    public int numDistinct(String s, String t) {

        // return DistinctSub(s,t,t.length()-1,s.length()-1);
        int dp[][] = new int[s.length()][t.length()];
        for(int []d : dp){
            Arrays.fill(d,-1);
        }
        return DistinctSub(s,t,t.length()-1,s.length()-1,dp);
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
}