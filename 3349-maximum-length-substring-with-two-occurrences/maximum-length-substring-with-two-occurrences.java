

class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> count = new HashMap<>(); 
            int lengthCount = 0;

            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                count.put(ch, count.getOrDefault(ch, 0) + 1);

                if (count.get(ch) > 2) { 
                    break;
                }

                lengthCount++;
                maxLength = Math.max(maxLength, lengthCount); 
            }
        }

        return maxLength;
    }
}
