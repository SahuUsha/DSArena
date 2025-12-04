class Solution {
    public int findPages(int[] arr, int k) {
        
        
        // code here
        if(k>arr.length){
            return -1;
        }
        
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i =0 ;i<arr.length;i++){
            low = Math.max(low,arr[i]);
            high += arr[i]; 
        }
        
        while(low<=high){
            int mid = (low + high)/2 ;
            int cntst = countStudents(arr,mid);
            if(cntst>k){
                low=mid+1;
            }else{
                high=mid-1;
            }
            
        }
        return low;
        
    }
    
    public static int countStudents(int[] arr , int pages){
        int student = 1;
        int pageStudent=0;
        for(int i =0 ; i<arr.length ;i++ ){
            if(pageStudent+arr[i]<=pages){
                pageStudent +=arr[i];
            }else{
               student++;
               pageStudent = arr[i];
            }
        }
        return student;
    }
}