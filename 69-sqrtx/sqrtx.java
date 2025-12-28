class Solution {
    public int mySqrt(int n) {

        if(n==0) return 0;
        
        int root = 0;
        int low =1;
        int high = n;
        while(low<=high){
            int mid = (low+high)/2;
            
            if(mid <= n / mid){
                root = Math.max(root, mid );
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return root;
    }
}