class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
         int l = 0, r =0 ;
         Set<Character> set = new HashSet<>();
         int MaxLen = 0;
         
         while(r<s.length()){
             char ch = s.charAt(r);
             
             while(set.contains(ch)){
                 
                 set.remove(s.charAt(l));
                 l++;
             }
         
             
                 set.add(ch);
                 int len = r-l+1;
                 MaxLen = Math.max(MaxLen,len);
             
              r++;
         }
        return MaxLen;
        
    }
}