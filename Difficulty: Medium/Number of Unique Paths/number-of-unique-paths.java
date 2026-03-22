// User function Template for Java

class Solution {
    // Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) {
        // Your code here
        
        // return uniquePath(a,b,0,0);
         return tabulation(a,b);
        
    }
    
    public static int uniquePath(int a , int b , int rht , int dwn){
        if(rht==a || dwn ==b){
            return 0;
        }
        
        if(rht==a-1 && dwn==b-1){
            return 1;
        }
        
        int sp1 =  uniquePath(a,b,rht+1,dwn);
        int sp2 =  uniquePath(a,b,rht,dwn+1);
        
        return sp1+sp2;
    }
    public static int tabulation(int m ,int n){
        int dp[][] = new int[m][n];

        for(int i = 0 ; i<m ;i++){
            for(int j = 0 ; j<n ;j++){
                if(i==0 && j==0) dp[i][j] =  1;
                else{
                    int up = 0;
                    int left = 0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
      return  dp[m-1][n-1];
    }
}