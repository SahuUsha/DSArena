class Solution {
    public int leastWeightCapacity(ArrayList<Integer> arr, int D) {

        int low = 0;
        int high = 0;

        for (int i = 0; i < arr.size(); i++) {
            high += arr.get(i);
            low = Math.max(low, arr.get(i));
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPackage(arr, D, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean isPackage(ArrayList<Integer> arr, int D, int wgh) {
        int day = 1;
        int sum = 0;

        for (int weight : arr) {
            if (sum + weight <= wgh) {
                sum += weight;
            } else {
                day++;
                sum = weight;
            }
        }

        return day <= D;
    }
}