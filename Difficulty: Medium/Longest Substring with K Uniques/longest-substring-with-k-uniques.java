class Solution {
    public int longestKSubstr(String s, int k) {
        return kDistinctChars(k,s);
        
    }
    public int longestKSubstr1(String s, int k) {
        // code here
        
        
    
     Set<Character> set = new HashSet<>();
     HashMap<Character, Integer> map = new HashMap<>();
     
     int r  = 0 ;
     int l = 0;
     
     int MaxLen = 0;
     
     while(r<s.length()){
         char ch =  s.charAt(r);
         set.add(ch);
         map.put(ch,map.getOrDefault(ch,0)+1);
         
         while(set.size()>k){
               ch = s.charAt(l);
             map.put(ch,map.getOrDefault(ch,0)-1);
             if(map.get(ch)==0){
                 set.remove(ch);
             }
         MaxLen = Math.max(MaxLen,r-l+1);
             l++;
         }
         
         r++;
         
     }
     if(s.length()==k && MaxLen==0){
          return s.length();
     }
     
     return MaxLen==0? -1 : MaxLen;
     
     
     
    }
    public static int kDistinctChars(int k, String str) {
		// Write your code here
	int p = k;
		// Write your code here
		HashMap<Character, Integer> map = new HashMap<>();
		Set<Character> set  =new HashSet<>();
		int maxLen = 0;
		int l = 0 , r=0;
		while(r<str.length()){
           
		   map.put(str.charAt(r),map.getOrDefault(str.charAt(r),0)+1);
		   set.add(str.charAt(r));

		   while(map.size()>k){
			   map.put(str.charAt(l),map.get(str.charAt(l))-1);

			   if(map.get(str.charAt(l))==0){
				   map.remove(str.charAt(l));
				   set.remove(str.charAt(l));
			   }
			   l++;
		   }

            if(set.size()==p){
		   maxLen = Math.max(maxLen,r-l+1);
			}
		   r++;

		}
		return maxLen==0?-1:maxLen;
	}
}