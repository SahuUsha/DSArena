class Solution {
    public String removeKdig(String s, int k) {
        // code here
        
        if(k==0) return s;
        
        Stack<Character> st = new Stack<>();
        for(int i=0 ; i<s.length();i++){
            
            while((!st.isEmpty()) && k>0 && st.peek()-'0' >s.charAt(i)-'0'){
                st.pop();
                k--;
            }
            
            st.push(s.charAt(i));
            
        } 
        
        while(k>0){
            st.pop();
            k--;
        }
        
        StringBuilder ans = new StringBuilder();
        
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        
        ans.reverse();
        
         while(ans.length()>1 && ans.charAt(0)=='0'){
            ans.deleteCharAt(0);
        }


       return ans.length()==0?"0":ans.toString();
    }
}