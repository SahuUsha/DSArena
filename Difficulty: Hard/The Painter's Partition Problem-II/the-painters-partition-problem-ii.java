class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int low = Integer.MIN_VALUE;
        int high =0;
        for(int i =0; i<arr.length;i++){
            low = Math.max(low,arr[i]);
            high +=arr[i];
        }
        
        while(low<=high){
            int mid = (low+high)/2;
            int cdiv = countDivide(arr,mid);
            if(cdiv>k){
                low = mid +1;
                
            }else{
                high = mid -1;
                
            }
        }
        return low;
        
    }
    public int  countDivide(int[] arr,int split){
        int divide = 1;
        
        int paintSubbaray =0;
        for(int i=0; i<arr.length;i++){
            if(paintSubbaray+arr[i]<=split){
                paintSubbaray += arr[i];
            }else{
                divide++;
                paintSubbaray = arr[i];
            }
        }
        return divide;
    }
     
}
