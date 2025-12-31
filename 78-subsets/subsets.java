class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        help(result , ans, nums, 0);
        return result;
        
    }

    public static void help(List<List<Integer>> result , List<Integer> ans , int []nums , int start){
        result.add(new ArrayList<>(ans));

        for(int i = start ;i<nums.length ;i++){
            
            ans.add(nums[i]);
            help(result,ans, nums,i+1);
            ans.remove(ans.size()-1);

        }
    }
}