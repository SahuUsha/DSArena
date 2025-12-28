class Solution {
    int floorSqrt(int n) {
        // code here
        
        int root = -1;
        int low =1;
        int high = n;
        while(low<=high){
            int mid = (low+high)/2;
            
            if(mid*mid<=n){
                root = Math.max(root, mid );
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return root;
    }
}