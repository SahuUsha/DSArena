class Solution {
    public int minDifference(int nums[]) {
      int n = nums.length;
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        boolean[][] dp = new boolean[n][totalSum + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (nums[0] <= totalSum) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= totalSum; target++) {

                boolean notTake = dp[i - 1][target];
                boolean take = false;

                // 🔒 Strict protection
                if (nums[i] <= target && target - nums[i] >= 0) {
                    take = dp[i - 1][target - nums[i]];
                }

                dp[i][target] = take || notTake;
            }
        }

        int minsum = Integer.MAX_VALUE;

        for (int s1 = 0; s1 <= totalSum / 2; s1++) {
            if (dp[n - 1][s1]) {
                int s2 = totalSum - s1;
                minsum = Math.min(minsum, Math.abs(s1 - s2));
            }
        }

        return minsum;
    }}
