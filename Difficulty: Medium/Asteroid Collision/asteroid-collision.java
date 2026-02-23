// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i<asteroids.length ; i++){
            int ele = asteroids[i];

            while((!st.isEmpty()) && ((st.peek() >0 && ele<0)) ){

                if(Math.abs(st.peek()) > Math.abs(ele)){
                    ele = 0;
                    break;
                }else if(Math.abs(st.peek()) < Math.abs(ele)){
                      st.pop();
                }else{
                    st.pop();
                    ele =0;
                    break;
                }

               
            }
             if(ele!=0){
                    st.push(ele);
                }
        }
        int []res = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        
        return res;
    }
}
