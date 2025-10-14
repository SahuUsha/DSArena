class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        

        int n = nums.length;
      Set<List<Integer>> set = new HashSet<>();
        for(int  i = 0 ; i<n; i++){
            for(int j = i+1 ; j<n ; j++){
                Set<Long> seen = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long fourth = (long) target - sum;

                    if (seen.contains(fourth)) {
                        List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
                        Collections.sort(quad);
                        set.add(quad);
                    }
                    seen.add((long) nums[k]);
            }
        }


    }
          return new ArrayList<>(set);
    }
}