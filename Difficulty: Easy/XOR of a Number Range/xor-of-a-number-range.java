class Solution {
    public static int findXOR(int l, int r) {
        // code here
       return xorTillN(r) ^ xorTillN(l-1);
    }
    
    public static int xorTillN(int n){
        
        if(n%4==0) return n;
        if(n%4==1) return 1;
        if(n%4==2) return n+1;
        
        return 0;
    }
}