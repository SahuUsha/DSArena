class Solution {
    

    
    int distinctSubseq(String str) {
        // code h
        // HashSet<String> set = new HashSet<>();
        
        // distictSubseq(0, set,str, "");
        
        // return set.size();
        
        return tabulation(str);
    }
   
    
    public static void distictSubseq(int idx , HashSet<String> set , String str , String path ){
        
        if(idx==str.length()){
            set.add(path);
        
            return;
        }
        if(set.contains(path)){
            return;
        }
        
        distictSubseq(idx+1 , set, str, path+str.charAt(idx));
        distictSubseq(idx+1 , set , str, path);
        
        
    }
    
    public static int tabulation(String str){
        
        int MOD = 1_000_000_007;
        
        int []dp = new int[str.length()+1];
        
        int last[] = new int[26];
        dp[0]=1;
        
        Arrays.fill(last, -1);
        
        
        for(int i =1 ; i<=str.length() ; i++){
            
            char ch = str.charAt(i-1);
            int idx = ch - 'a';
            
            dp[i] = (2*dp[i-1]) % MOD;
            
            
            if(last[idx]!=-1){
                
                dp[i] = (dp[i]-dp[last[idx]-1] + MOD) % MOD;
            }
            
            
            
            last[idx] = i;
        }
        
        return (int) dp[str.length()];
    }
} 