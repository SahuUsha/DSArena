class Solution {

    public boolean isKPartitionPossible(int[] arr, int k) {

        int n = arr.length;

        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        // Must be divisible
        if (sum % k != 0) return false;

        int target = sum / k;

        boolean[] used = new boolean[n];

        return canPartition(arr, used, k, 0, 0, target);
    }

    static boolean canPartition(int[] arr,
                                boolean[] used,
                                int k,
                                int start,
                                int currSum,
                                int target) {

        // If only one subset left → done
        if (k == 1) return true;

        // If current subset complete
        if (currSum == target) {
            return canPartition(arr, used, k - 1, 0, 0, target);
        }

        for (int i = start; i < arr.length; i++) {

            if (used[i]) continue;

            if (currSum + arr[i] > target) continue;

            used[i] = true;

            if (canPartition(arr,
                             used,
                             k,
                             i + 1,
                             currSum + arr[i],
                             target)) {
                return true;
            }

            used[i] = false;
        }

        return false;
    }
}