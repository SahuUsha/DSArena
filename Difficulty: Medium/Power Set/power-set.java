// User function Template for Java

class Solution {
    public List<String> AllPossibleStrings(String s) {
        List<String> ans = new ArrayList<>();
        StringBuffer rs = new StringBuffer();
        
         PossibleStrings(s,0,ans,rs);
         Collections.sort(ans);
         return ans;
    }
    
     public static void PossibleStrings(String s ,int idx, List<String> ans , StringBuffer rs){
         if(idx==s.length()){
               if (rs.length() > 0) {
                ans.add(rs.toString());
            }
            return;
         }
         
         
         
             rs.append(s.charAt(idx));
             PossibleStrings(s,idx+1,ans, rs);
             
             rs.deleteCharAt(rs.length() - 1);
              PossibleStrings(s,idx+1,ans, rs);
             
         
     }
  
}
