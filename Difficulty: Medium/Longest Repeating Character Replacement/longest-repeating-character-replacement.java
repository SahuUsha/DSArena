class Solution {
    public int longestSubstr(String s, int k) {
        // code here
       HashMap<Character,Integer> map = new HashMap<>();
       int maxFreq = 0;
       int maxLen = 0;
       
       int l =0 , r=0;
       int n = s.length();
       
       while(r<n){
           
           map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
           maxFreq = Math.max(maxFreq,map.get(s.charAt(r)));
           
               while(((r-l+1)-maxFreq)>k){
                   map.put(s.charAt(l),map.get(s.charAt(l))-1);
                   
                   if(map.get(s.charAt(l))==0){
                       map.remove(s.charAt(l));
                   }
                   
                   
                   l++;
                   
               }
               maxLen = Math.max(maxFreq,r-l+1);
               r  = r+1;
          
       
       
    }
   return maxLen;
}
}
