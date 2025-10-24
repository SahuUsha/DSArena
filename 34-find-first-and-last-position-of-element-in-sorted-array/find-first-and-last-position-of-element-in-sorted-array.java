class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] res ={-1,-1};

        int first = firstOcurrence(nums, target);
        if(first == -1) return res;
        int last = lastOcurrence(nums,target);


        res[0] = first;
        res[1] = last;

        return res;
    }
    public int firstOcurrence(int[] arr ,int target){

        int n = arr.length;

        int low = 0;
        int high = n-1;
        int first =-1;

        while(low<=high){
            int mid = (low + high) / 2;
            if(arr[mid]==target){
                first = mid;
               high = mid -1;
            }
            else if(arr[mid]<target){
                low = mid +1;
            }else{
                high = mid -1;
            }
        }
     return first;
    }


     public int lastOcurrence(int[] arr ,int target){

        int n = arr.length;

        int low = 0;
        int high = n-1;
        int last =-1;

        while(low<=high){
            int mid = (low + high) / 2;
            if(arr[mid]==target){
                last= mid;
                low = mid +1;
            }
            else if(arr[mid]<target){
                low = mid +1;
            }else{
                high = mid -1;
            }
        }
     return last;
    }
}