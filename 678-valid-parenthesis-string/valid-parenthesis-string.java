class Solution {
    public boolean checkValidString(String s) {

        int dp[][] =new int[s.length()][s.length()];
        for(int []d : dp){
            Arrays.fill(d,-1);
        }
        return ValidString(s,0,0,dp);


    }
    public boolean ValidString(String s , int idx , int cnt,int [][]dp){

        if(cnt<0){
            return false;
        }

        if(idx==s.length()){
            return cnt==0;
        }

        if(dp[idx][cnt]!=-1){
            return dp[idx][cnt]==0;
        }

        if(s.charAt(idx)=='('){
            dp[idx][cnt] = ValidString(s,idx+1,cnt+1,dp)==true? 0: 1;
        }
        else if(s.charAt(idx)==')'){
           dp[idx][cnt]  = ValidString(s,idx+1,cnt-1,dp)==true? 0: 1;
        }else{
           dp[idx][cnt] = (ValidString(s,idx+1,cnt+1,dp) || ValidString(s,idx+1,cnt-1,dp) || ValidString(s,idx+1,cnt,dp))==true? 0: 1;
        }

        return dp[idx][cnt]==0;

    }
}