class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i  = 0 ; i < nums.length ; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1;
            int k =n-1;

            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                 List<Integer> ans1 = new ArrayList<>();
ans1.add(nums[i]);
ans1.add(nums[j]);
ans1.add(nums[k]);

                    ans.add(ans1);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }

        }
        return ans;

    }

    // public List<List<Integer>> threeSum1(int[] nums) {
    //      Set<List<Integer>> st = new HashSet<>();
    //     int n = nums.length;

    //     for (int i = 0; i < n; i++) {
    //         Set<Integer> seen = new HashSet<>();

    //         for (int j = i + 1; j < n; j++) {
    //             int third = -(nums[i] + nums[j]);

    //             if (seen.contains(third)) {
    //                 List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
    //                 Collections.sort(triplet); 
    //                 st.add(triplet);
    //             }

    //             seen.add(nums[j]);
    //         }
    //     }

    //     return new ArrayList<>(st);

    // }
}