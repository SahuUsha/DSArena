class Solution {
    public static int countSubstring(String s) {
        // code here
        
        int cnt =0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        
        for(int i =0 ;i<s.length();i++){
            map.put(0,0);
            map.put(1,0);
            map.put(2,0);
            for(int j = i ;j<s.length();j++){
                
                map.put(s.charAt(j)-'a',1);
                
                if(map.get(0)+map.get(1)+map.get(2)==3){
                    cnt = cnt+(s.length()-j);
                    break;
                }
            }
        }
        return cnt;
        
    }
}
