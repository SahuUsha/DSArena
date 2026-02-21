class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        
       int leftmax = arr[0];
       int rightmax = arr[n-1];
       int l =0;
       int r = n-1;
       int total = 0;
       
       while(l<r){
          if(arr[l]<arr[r]){
              if(arr[l]>=leftmax){
                  leftmax = arr[l];
              }else{
                  total += leftmax - arr[l];
                  
              }
              l++;
          }else{
              if(arr[r]>=rightmax){
                  rightmax = arr[r];
              }else{
                  total += rightmax - arr[r];
                  
              }
              r--;
          }
       }
       
       return total;
    }
        
}
