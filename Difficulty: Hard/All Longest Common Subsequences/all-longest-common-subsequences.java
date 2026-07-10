class Solution {
     
    public ArrayList<String> allLCS(String s1, String s2) {
        // code here
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        
         for(int i = 0 ; i<=s2.length();i++){
           dp[0][i] = 0;
       }

        for(int i = 0 ; i<=s1.length();i++){
           dp[i][0] = 0;
       }
        
        for(int i = 1 ; i<=s1.length();i++){
            for(int j  =1 ;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                   dp[i][j] = 1+dp[i-1][j-1];
                }else{
                   dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
                }
            }
        }
        
        
        
        int idx = dp[s1.length()][s2.length()]-1;
        char result[] = new char[dp[s1.length()][s2.length()]];
        int  i = s1.length();
        int j = s2.length();
        
        
        Set<String> set=  DFS(i,j,s1,s2,dp);
        
        ArrayList<String> ans = new ArrayList<>();
        
        for(String s : set){
        //  System.out.println(s);
        ans.add(s);
        }
        
        Collections.sort(ans);
        
        return ans;
    }
    
    
     HashMap<String, Set<String>> memo = new HashMap<>();
   
    
     Set<String> DFS(int i, int j,String s1, String s2, int [][]dp){
         
         String key = i+","+j;
         
        
         if(memo.containsKey(key)){
            return memo.get(key);
         }
         
          Set<String> ans =new HashSet<>();
          
           if (i == 0 || j == 0) {
             ans.add("");
            }
            else if(s1.charAt(i-1)==s2.charAt(j-1)){
                for(String str : DFS(i-1,j-1,s1,s2,dp)){
                    ans.add(str+s1.charAt(i-1));
                }
            }else{
                if(dp[i-1][j]>=dp[i][j-1]){
                    ans.addAll(DFS(i-1,j,s1,s2,dp));
                }
                
                if(dp[i][j-1]>=dp[i-1][j]){
                     ans.addAll(DFS(i,j-1,s1,s2,dp));
                }
            }
            
            memo.put(key,ans);
                return ans;
     }
}