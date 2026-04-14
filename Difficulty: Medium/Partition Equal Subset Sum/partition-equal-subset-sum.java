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
        
        return subsetTab(arr,find);
        
        
        
    }
    static boolean subsetTab(int arr[], int tar){
        boolean dp[][] = new boolean[arr.length][tar+1];
        
        for(int i = 0 ;i<arr.length;i++){
            dp[i][0] = true;
        }
        
        if(tar>=arr[0]){
            dp[0][arr[0]] =true;
        }
        
        for(int i=1;i<arr.length;i++){
            for(int target = 1 ; target<=tar ;target++){
                boolean nottake = dp[i-1][target];
                
                boolean take = false;
                
                
                if(target>=arr[i]){
                    take = dp[i-1][target-arr[i]];
                    
                }
                
                dp[i][target] = nottake || take;
                
            }
        }
        
        return dp[arr.length-1][tar];
        
    }
}