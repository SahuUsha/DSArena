class Solution {
    public int numberOfSubarrays(int[] arr, int target) {
        // code here
        
        return numberSubarray(arr,target) - numberSubarray(arr,target-1);
    }
    
    public int numberSubarray(int[] arr, int target){
        int sum =0;
        int l = 0 , r=0;
        int ans = 0;
        
        
        while(r<arr.length){
            sum += arr[r];
            
            while(sum>target){
                sum =sum-arr[l];
                l++;
            }
            
            ans = ans +(r-l+1);
            r++;
            
        }
        
        return ans;
    }
}