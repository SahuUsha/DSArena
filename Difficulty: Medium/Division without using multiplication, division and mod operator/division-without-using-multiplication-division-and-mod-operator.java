// User function Template for Java

class Solution {
    public static long divide(long dividend, long divisor) {
        // code here
        long ans = (dividend / divisor);
        
        if(ans>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(ans<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        
        return ans;
        
    }
}