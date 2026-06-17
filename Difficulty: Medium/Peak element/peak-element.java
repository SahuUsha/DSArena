class Solution {
    public int peakElement(int[] arr) {
        // code here
        int  min = Integer.MIN_VALUE;
        
        for(int i = 0 ;i<arr.length ; i++){
            if(i==0){
                if( i+1<arr.length && min<arr[i] && arr[i]>arr[i+1]){
                    return i;
                }
            }
            
           else if(i==arr.length-1){
                if(min<arr[i]&& arr[i]>arr[i-1]){
                    return i;
                }
            }
            
           else if(arr[i-1]<arr[i] && arr[i]>arr[i+1]){
                return i;
            }
            
            
        }
        return 0;
    }
}