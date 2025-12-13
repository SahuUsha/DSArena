class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert map to list
        List<Map.Entry<Integer, Integer>> list =
                new ArrayList<>(map.entrySet());

        // Step 3: Sort
        Collections.sort(list, (e1, e2) -> {
            if (!e1.getValue().equals(e2.getValue())) {
                return e1.getValue() - e2.getValue(); // frequency increasing
            }
            return e2.getKey() - e1.getKey(); // value decreasing
        });

        // Step 4: Build result in nums itself
        int idx = 0;
        for (Map.Entry<Integer, Integer> e : list) {
            int freq = e.getValue();
            int key = e.getKey();
            for (int i = 0; i < freq; i++) {
                nums[idx++] = key;
            }
        }

        return nums;


    }
}