class Solution {
    final static int mod= 1000000007;
    public int sumSubarrayMins(int[] arr) {
        
        int []pses = PSE(arr);
        int []nses = NSE(arr);
        int n = arr.length;
        long total =0;


        for(int i = 0 ; i<arr.length ; i++){
            long left = i - pses[i];
            long right = nses[i] -i;

            total = (total + (left * right %mod * arr[i]) % mod) % mod;
        }

    return (int)total;

    }
    
   public int[] PSE(int []arr){
    Stack<Integer> st = new Stack<>();

    int []pses = new int[arr.length]; 
    for(int i=0 ; i<arr.length ; i++){

        while((!st.isEmpty()) && arr[st.peek()] > arr[i] ){
            st.pop();
        }

        pses[i] = st.isEmpty() ? -1 : st.peek();
        st.push(i);

    }
        return pses;
   }

   public int[] NSE(int []arr){
    Stack<Integer> st = new Stack<>();
    int n = arr.length;

    int []nses = new int[arr.length];

    for(int i = arr.length -1  ; i>=0 ;i--){

        while((!st.isEmpty()) && arr[st.peek()] >= arr[i]){
            st.pop();
        }

        nses[i] = st.isEmpty() ? n : st.peek();
        st.push(i);

    }
    return nses;
   }
}