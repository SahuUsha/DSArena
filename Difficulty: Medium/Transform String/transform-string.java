class Solution {
    public int transform(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return -1;
        }

        // Check both strings contain the same characters
        int[] freq = new int[256];

        for (char c : s1.toCharArray()) {
            freq[c]++;
        }

        for (char c : s2.toCharArray()) {
            freq[c]--;
        }

        for (int x : freq) {
            if (x != 0) {
                return -1;
            }
        }

        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int operations = 0;

        while (i >= 0) {

            if (s1.charAt(i) == s2.charAt(j)) {
                // Character remains in its relative position
                i--;
                j--;
            } else {
                // s1[i] is moved to the front
                operations++;
                i--;
            }
        }

        return operations;
    }
}