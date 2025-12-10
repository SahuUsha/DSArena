class Solution {
    public String reverseWords(String s) {
        System.out.println(s.length());
        StringBuilder ans = new StringBuilder();
        List<String> wordlist = new ArrayList<>(Arrays.asList(s.split(" ")));

        for (int i = wordlist.size() - 1; i >= 0; i--) { 

               String word = wordlist.get(i);
             if(word!=""){ ans.append(word).append(" ");}

        }
        
        return ans.toString().trim();
    }
}