class Solution {
    public int triangleNumber(int[] nums) {
        int validTriangle =0;
        Arrays.sort(nums);
        int n = nums.length;
        for(int k=n-1 ; k>=2 ; k-- ){
            int  i = 0 , j=k-1;
            while(i<j){
                if(nums[i]+nums[j]>nums[k]){
                    validTriangle += j-i;
                    j--; 
                }else{
                    i++;
                }
            }
            
            
        }
        return validTriangle;
    }
}