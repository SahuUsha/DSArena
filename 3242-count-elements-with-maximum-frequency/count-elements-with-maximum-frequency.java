class Solution {
    public int maxFrequencyElements(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
         for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;

        // Find max frequency
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        int total = 0;

        // Count how many elements have that frequency
        for (int freq : map.values()) {
            if (freq == maxFreq) {
                total += freq;
            }
        }

        return total;
       
        
    }
}