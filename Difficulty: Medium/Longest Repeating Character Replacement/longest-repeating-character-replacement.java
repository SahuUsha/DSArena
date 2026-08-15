class Solution {
    public int longestSubstr(String s, int k) {
        // code here
        int len =0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int l =0;
        
        for(int i =0 ; i<s.length();i++){
            
             map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
             
             max = Math.max(max , map.get(s.charAt(i)));
             
             while((i-l+1)-max>k){
                 
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
             }
             
             len = Math.max(len,i-l+1);
            
        }
        
        return len;
    }
}
