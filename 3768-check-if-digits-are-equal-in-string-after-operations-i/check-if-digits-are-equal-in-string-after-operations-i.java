class Solution {
    public boolean hasSameDigits(String s) {
        if(s.length()<=2){
            if(s.charAt(0)==s.charAt(1)){
              return true;
            }
        }
        while(s.length()>2){
            StringBuilder st = new StringBuilder();
            for(int i =1 ;i<s.length() ; i++){
                int val = ((int)s.charAt(i-1) + (int)s.charAt(i))%10;
                char ch = (char)('0'+val);
                st.append(ch);
            }

            s = st.toString();
            System.out.println(s);
        }
        if(s.length()<=2){
            if(s.charAt(0)==s.charAt(1)){
              return true;
            }
        }



        return false;

        
    }
}