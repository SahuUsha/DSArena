class Solution {

  void mergeSort(int arr[], int l, int r){
     mergeSort1(arr,l,r);
      
      
  }
  


   private static void mergeSort1(int arr[], int l, int r) {
        // code here
         if (l>= r)
            return;
        
        int mid = (l+r)/2;
        
        mergeSort1(arr,l,mid);
        mergeSort1(arr,mid+1,r);
        
        merge(arr,l,mid,r);
        
    }
    
    private static void merge(int arr[], int left , int mid, int right){
        
        int i = left;
        int j = mid+1;
        int k = 0;
        
        int len = right-left+1;
        
        int temp[] = new int[len];
        
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        
        
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        
        while(j<=right){
            temp[k++] = arr[j++];
        }
        
        for(int p = 0 ; p<len ;p++){
            arr[left+p] = temp[p];
        }
        
        
    }
    
    
}