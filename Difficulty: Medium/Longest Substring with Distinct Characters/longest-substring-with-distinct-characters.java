class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        HashMap<Character , Integer> map = new HashMap<>();
        
        int  l = 0 , r = 0;
        int len = 0;
        while(l<s.length() && r<s.length()){
            
            
               map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
            
            
            while(map.get(s.charAt(r))>1){
                
                    
                        map.put(s.charAt(l), map.getOrDefault(s.charAt(l),0)-1);
                        l++;
                       
            }
            
            len = Math.max(len , r-l+1);
            r++;
        }
    
    return len;
    }
}