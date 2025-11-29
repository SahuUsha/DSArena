class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i=0; i<nums.length;i++){
            low = Math.min(low, nums[i]);
            high = Math.max(high, nums[i]);
        }
        
        while(low<=high){
          int  mid = low+(high-low)/2;
            if(sumDivision(nums,threshold,mid)<=threshold){
                 high= mid-1;
            }else if(sumDivision(nums,threshold,mid)>threshold){
                 low= mid+1;
            }
        }
        return low;
    }

    public int sumDivision(int[] nums , int threshold , int div){
        int count = 0;

        for (int num : nums) {
            count += (num + div - 1) / div; // same as ceil(num / div)
        }
        System.out.println(count);

        return count;
    }
}