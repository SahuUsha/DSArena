class Solution {
    public int countSubarrays(int[] arr, int k) {
        return countSubarrays1(arr,k) - countSubarrays1(arr,k-1);
        
    }   
    public int countSubarrays1(int[] arr, int k) {
        // code here
        
        int sum =0;
        int l =0;
        int cnt = 0;
        
        for(int r =0 ;r<arr.length ;r++){
            
            if(arr[r]%2!=0){
                sum++;
            }
            
            while(sum>k){
                
                if(arr[l]%2!=0){
                    sum--;
                    l++;
                    break;
                }else{
                    l++;
                }
            }
            
            cnt += r-l+1;
            
        }
        
        return cnt;
    }
}
