class Solution {
    public long maxSubarraySum(int[] nums, int k) {
         int n = nums.length;
    long[] prefix = new long[n + 1];


    for (int i = 1; i <= n; i++) {
        prefix[i] = prefix[i - 1] + nums[i - 1];
    }

    long maxValue = Long.MIN_VALUE;

    
    // for (int start = 0; start < n; start++) {
    //     for (int end = start + k; end <= n; end += k) {
    //         long sum = prefix[end] - prefix[start];
    //         maxValue = Math.max(maxValue, sum);
    //     }
    // }

    long minPrefix[] = new long[k];
    for(int i = 0 ; i<k ;i++){
        minPrefix[i] = Long.MAX_VALUE;
    }


    for (int j = 0; j <= n; j++) {
    int mod = j % k;

    if (minPrefix[mod] != Long.MAX_VALUE) {
        long sum = prefix[j] - minPrefix[mod];
        maxValue = Math.max(maxValue, sum);
    }

    minPrefix[mod] = Math.min(minPrefix[mod], prefix[j]);
}


    return maxValue;
    }
}