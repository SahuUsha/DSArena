class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer , Integer> map = new HashMap<>();

      for (int num : nums) {
            int rem = ((num % value) + value) % value; // handle negatives safely
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

    
        int i = 0;
        while (true) {
            int rem = i % value;
            int count = map.getOrDefault(rem, 0);
            if (count == 0) {
                return i; 
            }
            map.put(rem, count - 1); 
            i++;
        }
    }
}