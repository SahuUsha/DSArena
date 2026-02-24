class Solution {
    public String removeKdigits(String num, int k) {
        return RemoveKdig(num,k);
    }

    public String RemoveKdig(String num , int k){
        if(k==0) return num;

        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i<num.length() ; i++){
            char ch = num.charAt(i);
           if(st.empty()){
            st.push(ch);
            continue;
           }
           while (!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }

           st.push(ch);
           
        }

        while(k>0 && (!st.isEmpty())){
            st.pop();
            k--;
        }
        

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        sb.reverse();

        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }


       return sb.length()==0?"0":sb.toString();
    }
}