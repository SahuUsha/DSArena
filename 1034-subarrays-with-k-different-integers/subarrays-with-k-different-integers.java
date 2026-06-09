class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithKDistinct1(nums,k) - subarraysWithKDistinct1(nums,k-1);


    }
    public int subarraysWithKDistinct1(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
       

        int l =0;
        int cnt = 0;

        int n = nums.length;

        for(int r = 0 ; r<nums.length ;r++){
           
           map.put(nums[r], map.getOrDefault(nums[r],0)+1);

           while(map.size()>k){
            map.put(nums[l], map.getOrDefault(nums[l],0)-1);

            if(map.get(nums[l])==0){
                map.remove(nums[l]);
            }

           l++;
           }
           cnt = cnt+ (r-l+1);
        }

        return cnt;
        

    }
}