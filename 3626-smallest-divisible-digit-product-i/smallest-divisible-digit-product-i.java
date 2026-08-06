class Solution {
    public int smallestNumber(int n, int t) {
       
       while(n<=100){
        
        boolean check = diagnostic(n,t);

        if(check==true) return n;

        n++;
       }

       return n;

    }

    public static boolean diagnostic(int num, int t){
            int prd = 1;
        while(num!=0){
            int rem = num%10;
            prd = prd * rem;
            num = num/10;
        }
        if(prd%t==0) return true;
        return false;
    }
}