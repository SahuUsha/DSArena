class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);

                if (seen.contains(third)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(triplet); 
                    st.add(triplet);
                }

                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(st);

    }
}