class Solution {
    public int maxDepth(String s) {

        int parenth = 0;
        int maxparen = 0;
        for(int i=0; i<s.length();i++){

            if(s.charAt(i)=='('){
                parenth++;
                if(maxparen<parenth){
                 maxparen = parenth;
                }
            }else if(s.charAt(i)==')'){
                parenth--;
            }
        }
        return maxparen;
       
    }
}