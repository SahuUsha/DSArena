class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // List<List<Integer>> result = new ArrayList<>();
        // List<Integer> ans = new ArrayList<>();
        // help(result , ans, nums, 0);
        // return result;
        
        return bitmethod(nums);
    }

    // public static void help(List<List<Integer>> result , List<Integer> ans , int []nums , int start){
    //     result.add(new ArrayList<>(ans));

    //     for(int i = start ;i<nums.length ;i++){
            
    //         ans.add(nums[i]);
    //         help(result,ans, nums,i+1);
    //         ans.remove(ans.size()-1);

    //     }
    // }

     public static List<List<Integer>> bitmethod(int[] nums) {
        int n = nums.length;
        int sample = 1 << n;   // 2^n
        List<List<Integer>> ans = new ArrayList<>();

        for (int num = 0; num < sample; num++) {
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0) {   // ✅ correct bit check
                    res.add(nums[i]);
                }
            }

            ans.add(res);
        }
        return ans;
    }


}