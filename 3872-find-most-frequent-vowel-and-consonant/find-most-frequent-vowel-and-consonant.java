class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character , Integer> vowelmap = new HashMap<Character  , Integer>();
        HashMap<Character , Integer> consmap = new HashMap<Character  , Integer>();

        for(int i =0 ;i<s.length() ;i++){
            if(isVowel(s.charAt(i))){
                vowelmap.put(s.charAt(i), vowelmap.getOrDefault(s.charAt(i),0)+1);
            }else{
                consmap.put(s.charAt(i), consmap.getOrDefault(s.charAt(i),0)+1);
            }
            
        }
        

        int maxv =0;
        int maxc = 0;

       for (Map.Entry<Character , Integer> entryv : vowelmap.entrySet()) {
System.out.println("Key = " + entryv.getKey() + ", Value = " + entryv.getValue());
        maxv =  Math.max(maxv, entryv.getValue());
}
        
         for (Map.Entry<Character , Integer> entryc : consmap.entrySet()) {
System.out.println("Key = " + entryc.getKey() + ", Value = " + entryc.getValue());
        maxc =  Math.max(maxc, entryc.getValue());
}


return maxv+maxc;
        

        
    }
    public static boolean isVowel(char c){
        if(c=='a' || c == 'e' || c=='i' || c=='o' || c=='u'){
            return true;
        }
        return false;
    }
}