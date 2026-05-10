class Solution {
    public int numberOfSubstrings(String s) {
        
        int cnt = 0;
        int last[] = {-1,-1,-1};

        for(int i = 0 ; i<s.length() ; i++){
        
        last[s.charAt(i)-'a'] = i;

        int min = Math.min(last[0] , Math.min(last[1],last[2]));

        if(min!=-1){
            cnt+= (1+min);
        }
        
        }
      return cnt;

    }
}