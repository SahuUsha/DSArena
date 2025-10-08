class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = potions.length;
        int[] res = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            long minPotion = (success + spells[i] - 1) / spells[i]; // ceil division
            int index = binarySearch(potions, minPotion);
            res[i] = m - index;
        }

        return res;
    }

    private int binarySearch(int[] potions, long target) {
        int low = 0, high = potions.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (potions[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
