class Solution {
    public boolean areIsomorphic(String s, String t) {
        // code here
       int map1[] = new int[200];
       int map2[] = new int[200];

       if(s.length()!=t.length()){
        return false;
       }
        
    for(int i =0 ;i <s.length();i++){

        if(map1[s.charAt(i)] != map2[t.charAt(i)]){
            return false;
        }

        map1[s.charAt(i)] = i+1;
        map2[t.charAt(i)] = i+1;



    }
    return true;
        
    }
}