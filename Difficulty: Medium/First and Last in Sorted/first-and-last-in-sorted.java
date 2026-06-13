class Solution {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int fs = findFirst(arr,x);
        int ls = findLast(arr,x);
        
        
        list.add(fs);
        list.add(ls);
        
        
        return list;
    }
    
    public int findFirst(int arr[] , int x){
        int low = 0;
        int high = arr.length-1;
        int ans =-1;
        
        
        while(low<=high){
            
            int mid= (low+high)/2;
            
            if(arr[mid]==x){
                ans = mid;
                high = high-1;
            }else if(arr[mid]>x){
                high = high-1;
            }else{
                low = low+1;
            }
        }
        
        return ans;
    }
    
    public int findLast(int arr[] , int x){
        int low =0;
        int high = arr.length-1;
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            
            if(arr[mid]==x){
                ans = mid;
                low = low+1;
            }else if(arr[mid]>x){
                high = high-1;
            }else{
                low = low+1;
            }
        }
        
        return ans;
    }
}
