class Solution {
    void selectionSort(int[] arr) {
        // code here
        
        
        for(int i = 0 ; i<arr.length ;i++){
            int min = arr[i];
            int min_idx = i;
            
            for(int j = i ; j<arr.length ; j++){
                
                if(min > arr[j]){
                    min = arr[j];
                    min_idx = j;
                }
            }
            
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
        
        
    }
}