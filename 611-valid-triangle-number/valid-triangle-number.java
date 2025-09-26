class Solution {
    public int triangleNumber(int[] nums) {
        int validTriangle =0;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0 ; i<=n-3 ; i++ ){
            
            for(int j =i+1 ; j<=n-2 ; j++){
                for(int k = j+1 ; k<=n-1 ; k++){
                    if(nums[i]+nums[j] >nums[k]){
                        validTriangle++;
                    }
                }
            }
        }
        return validTriangle;
    }
}