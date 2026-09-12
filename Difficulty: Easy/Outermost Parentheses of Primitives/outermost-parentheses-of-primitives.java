class Solution {
    public String removeOuter(String s) {
        // code here
        
        Stack<Character> st = new Stack<>();
        StringBuilder str = new StringBuilder();
        
        for(int i = 0 ; i<s.length() ; i++){
            
            
            if(st.isEmpty()){
                
                if(s.charAt(i)=='('){
                     st.push(s.charAt(i));
                }
                 
            }
            else{
                
                if(st.size()>1 && s.charAt(i)==')'){
                    st.pop();
                     str.append(s.charAt(i));
                }else if(st.size()==1 && s.charAt(i)==')'){
                    st.pop();
                }
                else if(s.charAt(i) == '('){
                    st.push(s.charAt(i));
                    str.append(s.charAt(i));
                }
            }
            
        }
        
        return str.toString();
        
        
    }
}