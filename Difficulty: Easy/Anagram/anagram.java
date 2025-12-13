class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        // code here
        HashMap<Character, Integer> map1= new HashMap<>();
        HashMap<Character, Integer> map2= new HashMap<>();
        
        if(s1.length()!=s2.length()){
            return false;
        }
        
        for(int i =0 ;i<s1.length();i++){
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i),0)+1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i),0)+1);
        }
        
        for(Map.Entry<Character, Integer> ent : map1.entrySet()){
            char ch = ent.getKey();
            if(!map2.containsKey(ch) || !ent.getValue().equals(map2.get(ch))){
                return false;
            }
        }
        return true;
        
    }
}