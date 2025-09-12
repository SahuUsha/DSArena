class Solution {
    public boolean doesAliceWin(String str) {
        int vowel = 0;


        for(int i = 0 ; i< str.length() ; i++){
            if(isVowel(str.charAt(i))){
                vowel++;
            }

        }

        if(vowel>0){
            return true;
        }else{
            return false;
        }

        
    }
      public static boolean isVowel(char c) {
        char ch = Character.toLowerCase(c);
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}
