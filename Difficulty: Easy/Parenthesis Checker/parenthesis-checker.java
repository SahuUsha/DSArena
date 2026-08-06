class Solution {
    public boolean isBalanced(String s) {
        // code here
         
         Stack<Character> st = new Stack<>();
         
        for(int i = 0 ; i<s.length(); i++){
            
            
            
            if(!st.isEmpty() &&( s.charAt(i)=='}' && st.peek()=='{' || s.charAt(i)==']' && st.peek()=='['|| 
            s.charAt(i)==')' && st.peek()=='(')) 
           {  st.pop();
               continue;
           }
            else st.push(s.charAt(i));
        }
        
        if(st.size()!=0) return false;
        else return true;
    }
}
