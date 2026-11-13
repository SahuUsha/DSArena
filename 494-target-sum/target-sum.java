class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        return findTarget(nums,target,0,0);
        
    }
    public int findTarget(int []nums, int target , int idx, int sum){
        
        if(idx==nums.length){
        if(sum==target){
            return 1;
        }
        }
        
        if(idx>=nums.length){
            return 0;
        }

        int minus = findTarget(nums,target,idx+1,sum-nums[idx]);

        int pos = findTarget(nums,target,idx+1,sum+nums[idx]);

        return minus + pos;
    }
}