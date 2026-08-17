class Solution {
    public static String minWindow(String s, String p) {
        // code here
        
        HashMap<Character, Integer> tmap = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int minlen = Integer.MAX_VALUE;
        int start = 0;
        int l =0,  r=0;
        for(int i = 0 ; i<p.length() ;i++){
            tmap.put(p.charAt(i),tmap.getOrDefault(p.charAt(i),0)+1);
            set.add(p.charAt(i));
        }
        
        while(r<s.length()){
            
            if(tmap.containsKey(s.charAt(r))){
                tmap.put(s.charAt(r) , tmap.get(s.charAt(r))-1);
                
                if(tmap.get(s.charAt(r))==0){
                    set.remove(s.charAt(r));
                }
            }
            
            while(l <= r && set.size()==0){
                
                if(r-l+1<minlen){
                    minlen = r-l+1;
                    start = l;
                }
                
                if(tmap.containsKey(s.charAt(l))){
                    
                    if(tmap.get(s.charAt(l))==0){
                       tmap.put(s.charAt(l),tmap.getOrDefault(s.charAt(l),0)+1);
                       set.add(s.charAt(l)); 
                    }else{
                        tmap.put(s.charAt(l),tmap.getOrDefault(s.charAt(l),0)+1);
                    }
                }
                
                l++;
            }
            r++;
        }
        return minlen == Integer.MAX_VALUE
        ? ""
        : s.substring(start, start + minlen);
    }
}