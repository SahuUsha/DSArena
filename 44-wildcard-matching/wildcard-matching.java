class Solution {
    public boolean isMatch(String s, String p) {


        int dp[][] = new int[s.length()+1][p.length()+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return  match(s,p,s.length()-1,p.length()-1,dp);

    }

    public boolean match(String s, String p , int idxs, int idxt, int dp[][]){
  if(idxs<0 && idxt<0){
    return true;

  }

  if(idxt<0){
    return false;
  }

  if(idxs<0){
    while(idxt>=0){
        if(p.charAt(idxt)!='*'){
            return false;
        }
        idxt--;
    }
    return true;
  }

  if(dp[idxs][idxt]!=-1){
    return dp[idxs][idxt]==0 ? false : true ;
  }

    
    if(s.charAt(idxs)==p.charAt(idxt) || p.charAt(idxt)=='?'){
        dp[idxs][idxt] =   match(s,p,idxs-1,idxt-1,dp)==true ? 1: 0;
    }
    else if(p.charAt(idxt)=='*'){
         dp[idxs][idxt] =  (match(s,p,idxs,idxt-1,dp) || match(s,p,idxs-1,idxt,dp)) ==true ? 1: 0 ;
    }
   
  return dp[idxs][idxt] == 1;
    }

 

}