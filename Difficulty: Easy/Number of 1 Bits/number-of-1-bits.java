// User function Template for Java
class Solution {
    static int setBits(int n) {
        // code here
         
         int count = 0;
         while(n>1){
             
             count += n&1;
             n = n>>1;
         }
         if(n==1){
             count +=1;
         }
         
         return count;
    }
}