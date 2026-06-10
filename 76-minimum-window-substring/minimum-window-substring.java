class Solution {
    public String minWindow(String s, String t) {
        return window(s,t);
    }
    public String window(String s,String t){
        StringBuffer ans = new StringBuffer();
        HashMap<Character,Integer> tmap = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for(int  i = 0 ;i<t.length();i++){
            tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);
            set.add(t.charAt(i));
        }

        int l =0,r=0;
      int minLen = Integer.MAX_VALUE;
      int start =0;

        
        while(r<s.length()){
            
             if(tmap.containsKey(s.charAt(r))){
            tmap.put(s.charAt(r),tmap.get(s.charAt(r))-1);
            if(tmap.get(s.charAt(r))==0){
                set.remove(s.charAt(r));
            }
            }


            while(set.size()==0){

                  if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                if(tmap.containsKey(s.charAt(l))){
                   

                   if(tmap.get(s.charAt(l))==0){
                    tmap.put(s.charAt(l), tmap.get(s.charAt(l))+1);
                    set.add(s.charAt(l));
                   }else{
                    tmap.put(s.charAt(l), tmap.get(s.charAt(l))+1);
                   }
                    
                }
                  
                    l++;
            }

           r++;

        }
       return minLen == Integer.MAX_VALUE
       ? ""
       : s.substring(start, start + minLen);
    }
 
}