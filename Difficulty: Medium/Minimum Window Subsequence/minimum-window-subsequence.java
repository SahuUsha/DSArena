class Solution {
    public String minWindow(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        if (m > n) return "";

        int i = 0;
        int minSub = Integer.MAX_VALUE;
        int start = -1;

        while (i < n) {

            int j = 0;

            // Forward scan
            while (i < n) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;

                    if (j == m) {
                        break;
                    }
                }
                i++;
            }

            if (j < m) break;

            int end = i + 1;

            // Move back to last matched position
            

            // Backward scan
            j = m - 1;

            while (j >= 0) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j--;
                }
                i--;
            }

            int windowStart = i + 1;

            if (end - windowStart < minSub) {
                minSub = end - windowStart;
                start = windowStart;
            }

            i = windowStart + 1;
        }

        return start == -1 ? "" : s1.substring(start, start + minSub);
    }
}