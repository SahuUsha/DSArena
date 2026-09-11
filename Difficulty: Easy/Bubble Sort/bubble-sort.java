class Solution {
    public void bubbleSort(int[] arr) {
        // code here
        
        for(int  i = 1 ; i<arr.length; i++){
            for(int j = 1; j<arr.length -i +1 ; j++){
                
                if(arr[j-1]>arr[j]){
                    arr[j-1] = arr[j-1]+arr[j];
                    arr[j] = arr[j-1]- arr[j];
                    arr[j-1] = arr[j-1] - arr[j];
                }
            }
        }
        
    }
}