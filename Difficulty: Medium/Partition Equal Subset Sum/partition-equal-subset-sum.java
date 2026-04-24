class Solution {
    static boolean equalPartition(int arr[]) {
        // code here
        
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
        
        }
        
        if(sum%2!=0) {return false;}
        
        // System.out.println("Sumaiton :"+sum);
        
        int find = sum/2;
        
        return isPartition(arr,find);
        
        
        
    }
   static boolean isPartition(int arr[],int find){
       
       boolean  [][]dp = new boolean[arr.length][find+1];
       
       if(find>=arr[0]){
           
       dp[0][arr[0]] =true;
       }
       
       for(int i = 0; i<arr.length;i++){
           dp[i][0] = true;
       }
       
       for(int i = 1; i<arr.length ;i++){
           for(int tar = 1; tar<=find;tar++){
               
               boolean nottake = dp[i-1][tar];
               
               boolean take = false;
               
               if(tar>=arr[i]){
                   take = dp[i-1][tar-arr[i]];
               }
               
               dp[i][tar] = take|| nottake;
        
               
           }
       }
       
       return dp[arr.length-1][find];
       
       
   }
    
    
}