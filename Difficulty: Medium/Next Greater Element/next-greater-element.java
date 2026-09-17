class Solution {
    
    
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
       
        for(int i = arr.length-1 ; i>=0 ; i--){
            
            if(st.isEmpty()){
                result.add(-1);
                st.push(arr[i]);
                
            }else{
                
                if(!st.isEmpty() &&st.peek()>arr[i]){
                    result.add(st.peek());
                    st.push(arr[i]);
                }else{
                    
                    while(!st.isEmpty() && st.peek()<=arr[i]){
                        st.pop();
                    }
                    if(st.isEmpty()){
                    result.add(-1);
                       st.push(arr[i]);
                
                    }else{
                        result.add(st.peek());
                         st.push(arr[i]);
                    }
                    
                }
            }
            
        }
    
        Collections.reverse(result);
        
        return result;
        
    }
}