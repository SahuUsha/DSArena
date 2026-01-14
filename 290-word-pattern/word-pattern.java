class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] wordArray = s.split(" ");  // Splits by spaces
       HashMap<Character , String> map = new HashMap<>();
       HashMap<String, Character> reverseMap = new HashMap<>();

       if (pattern.length() != wordArray.length) return false;

       for(int i = 0 ;i< pattern.length();i++){
        char ch = pattern.charAt(i);
        String word = wordArray[i];

        if(map.containsKey(ch)){
            if(!map.get(ch).equals(word)){
                return false;
            }

        }else{
           if(reverseMap.containsKey(word)) return false;
           map.put(ch,word);
           reverseMap.put(word, ch);
            
        }
       }
 return true;
        
    }
}