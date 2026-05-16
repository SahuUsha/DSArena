class Solution {
    static void rotateArr(int arr[], int d) {
        // code here
        
        
        int n = arr.length;
        
        if(d>n){
            d = d%n;
        }
       
       int []temp = new int[d];
       
       for(int i = 0 ; i<d;i++){
           temp[i] = arr[i];
       }
        
       for(int i =0 ; i<n-d;i++){
           arr[i] = arr[i+d];
       }
       
       int j= 0;
       
       for(int i = n-d ;i<n; i++){
           arr[i] = temp[j++];
       }
        
        
    }
}