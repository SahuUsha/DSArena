class Solution {
    public void quickSort(int[] arr, int low, int high) {
        // code here

        if (low < high) {

            int partitionIdx = partition(arr, low, high);

            quickSort(arr, low, partitionIdx);
            quickSort(arr, partitionIdx + 1, high);

        }
    }

    private int partition(int[] arr, int low, int high) {
        // code here

        int pivot = arr[low];

        int i = low;
        int j = high;

        while (true) {

            while (i <= high && arr[i] < pivot) {
                i++;
            }

            while (j >= low && arr[j] > pivot) {
                j--;
            }

            if (i >= j) {
                return j;
            }

            // Swap
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];

            i++;
            j--;
        }
    }
}