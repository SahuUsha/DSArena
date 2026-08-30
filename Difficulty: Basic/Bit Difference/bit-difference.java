class Solution {
    public static int countBitsFlip(int a, int b) {
        // code here
        
        int n = a^b;
        int opt =0;
        
        while(n>0){
            
            if((n & 1)>0){
            opt++;
            }
            n  = n>>1;
        }
        
        return opt;
    }
}
