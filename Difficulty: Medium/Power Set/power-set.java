// User function Template for Java

class Solution {
    public List<String> AllPossibleStrings(String s) {
        List<String> ans = new ArrayList<>();
        
        PossibleStr(s,ans);
        Collections.sort(ans);
        

         return ans;
    }
    
    //  public static void PossibleStrings(String s ,int idx, List<String> ans , StringBuffer rs){
    //      if(idx==s.length()){
    //           if (rs.length() > 0) {
    //             ans.add(rs.toString());
    //         }
    //         return;
    //      }
         
         
         
    //          rs.append(s.charAt(idx));
    //          PossibleStrings(s,idx+1,ans, rs);
             
    //          rs.deleteCharAt(rs.length() - 1);
    //           PossibleStrings(s,idx+1,ans, rs);
             
         
    //  }
  
  
    public void PossibleStr(String s ,List<String> ans){
        
        int n  = s.length();
        
        for(int i = 1 ; i<(1<<n);i++){
            
            StringBuilder str = new StringBuilder();
            
            for(int j = 0 ; j<n ;j++){
                
                if((i & (1 << j)) != 0){
                    str.append(s.charAt(j));
                }
                
            }
            ans.add(str.toString());
        }
        
    }
}
