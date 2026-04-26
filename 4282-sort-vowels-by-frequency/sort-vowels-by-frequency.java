class Solution {
    public String sortVowels(String s) {
        Set<Character> vowels = Set.of('a','e','i','o','u');
        
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> firstIndex = new HashMap<>();
        
        // Step 1: Count frequency + first occurrence
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowels.contains(c)) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
                firstIndex.putIfAbsent(c, i);
            }
        }
        
        // Step 2: Extract vowels
        List<Character> vowelList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                vowelList.add(c);
            }
        }
        
        // Step 3: Sort vowels
        Collections.sort(vowelList, (a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return freq.get(b) - freq.get(a);
            }
            return firstIndex.get(a) - firstIndex.get(b);
        });
        
        // Step 4: Rebuild string
        StringBuilder result = new StringBuilder(s);
        int idx = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                result.setCharAt(i, vowelList.get(idx++));
            }
        }
        
        return result.toString();
    }
}