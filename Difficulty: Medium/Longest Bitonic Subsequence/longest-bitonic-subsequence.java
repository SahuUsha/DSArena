import java.util.Arrays;

class Solution {
    public static int longestBitonicSequence(int n, int[] nums) {

        int[] forwardLIS = new int[n];
        int[] backwardLIS = new int[n];

        Arrays.fill(forwardLIS, 1);
        Arrays.fill(backwardLIS, 1);

        // LIS from left to right
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i] &&
                    forwardLIS[prev] + 1 > forwardLIS[i]) {

                    forwardLIS[i] = forwardLIS[prev] + 1;
                }
            }
        }

        // LDS from right to left
        for (int i = n - 1; i >= 0; i--) {
            for (int next = n - 1; next > i; next--) {
                if (nums[next] < nums[i] &&
                    backwardLIS[next] + 1 > backwardLIS[i]) {

                    backwardLIS[i] = backwardLIS[next] + 1;
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            // For GFG, bitonic sequence must have both increasing and decreasing parts
            if (forwardLIS[i] > 1 && backwardLIS[i] > 1) {
                max = Math.max(max, forwardLIS[i] + backwardLIS[i] - 1);
            }
        }

        return max;
    }
}