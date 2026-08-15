class Solution {
    public static int countSubstring(String s) {
        // code here
        
        
        int last[] = {-1,-1,-1};
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        
        
        for(int i = 0 ; i<s.length() ; i++){
            
            last[s.charAt(i)-'a'] =i;
            
            min = Math.min(last[0] , Math.min(last[1], last[2]));
            
            if(min!=-1){
                cnt +=(1+min);
            }
        }
        
        
        return cnt;
        
    }
}
