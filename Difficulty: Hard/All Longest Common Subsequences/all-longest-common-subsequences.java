class Solution {
    public ArrayList<String> allLCS(String s1, String s2) {
        // code here
        
        return LCS(s1,s2);
        
        
    }
    
    public ArrayList<String> LCS(String s1 , String s2){
        
        int dp[][]  = new int[s1.length()+1][s2.length()+1];
        
        for(int  i = 1 ; i<=s1.length() ;i++){
            for(int j = 1 ; j<=s2.length() ;j++){
                
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        
        int idx = dp[s1.length()][s2.length()]-1;
        int i = s1.length();
        int j = s2.length();
        

       HashMap<String, Set<String>> memo = new HashMap<>();
        
        Set<String> set = DFS(i,j,s1,s2,dp,memo);
        
        ArrayList<String> result = new ArrayList<>();
        
        for(String str : set){
            result.add(str);
        }
        
        Collections.sort(result);
        return result;
            
            
        }
        
        
    public static Set<String> DFS(int i , int j , String s1, String s2, int dp[][],HashMap<String, Set<String>> memo ){
        
        String key = i+","+j;
        
        if(memo.containsKey(key)){ return memo.get(key); }
        
        
        
        Set<String> ans  = new HashSet<>();
         
        if(i==0 || j==0){
            ans.add("");
        }
        
        else if(s1.charAt(i-1)==s2.charAt(j-1)){
            
            for(String str : DFS(i-1,j-1,s1, s2,dp,memo)){
                ans.add(str+s1.charAt(i-1));
            }
        }
        else {
            if(dp[i-1][j] >= dp[i][j-1]){
            ans.addAll(DFS(i-1,j,s1,s2,dp,memo));}
             
            if(dp[i-1][j] <= dp[i][j-1]){
            ans.addAll(DFS(i,j-1,s1,s2,dp,memo));
            }
        }
        
        
        memo.put(key,ans);
        return ans;
    }
        
    
}