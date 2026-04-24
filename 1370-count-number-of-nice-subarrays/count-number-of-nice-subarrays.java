class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return countodd(nums,k) - countodd(nums,k-1);


    }
    public int countodd(int []nums , int k){
        int l =0;
        int r=0;
        int cnt = 0;
        int sum=0;

        while(r<nums.length){
         

              if(nums[r]%2!=0){
                sum++;
            }

            while(sum>k){
                if(nums[l]%2!=0){
                    sum--;
                    l++;
                    break;
                }else{
                    l++;
                }
            }

            cnt = cnt+(r-l+1);
            r++;
        }

        return cnt;
    }
}