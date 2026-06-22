class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i = 0 ; i<arr.length ; i++){
            high = Math.max(high,arr[i]);
        }
        int ans = 0;
        while(low<=high){
            int mid = (low+high)/2;
            
            int time = counter(mid,arr);
            if(time>k){
                low = mid+1;
            }else{
            
                high = mid-1;
            }
        }
        return low;
        
    }
    
    public int counter(int banana,int arr[]){
        int count = 0;
        for(int i = 0 ; i <arr.length ;i++){
            count += arr[i]%banana==0?arr[i]/banana : arr[i]/banana+1;
        }
        return count;
    }
}
