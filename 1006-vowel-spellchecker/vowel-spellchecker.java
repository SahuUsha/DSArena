class Solution {

    public static final Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));

    

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> wordset = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> csMap = new HashMap<>();
        Map<String, String> vlMap = new HashMap<>();
            String result[] = new String[queries.length];

        for(String word : wordlist){
            String lower = word.toLowerCase();
            csMap.putIfAbsent(lower, word);
            String msk = devowel(word);
            vlMap.putIfAbsent(msk, word);


        }
            for( int i = 0 ; i<queries.length ; i++){

                String q = queries[i];

                if(wordset.contains(q)){
                    result[i] = q;

                }else{
                    String qlower = q.toLowerCase();

                    if(csMap.containsKey(qlower)){
                        result[i] = csMap.get(qlower);
                    }else{
                       
                        String mskq = devowel(qlower);

                        if(vlMap.containsKey(mskq)){
                            result[i] = vlMap.get(mskq);
                        }else{
                            result[i] ="";
                        }
                    }
                }
            }

        
         return result;
    }




     public static String devowel(String word){
        StringBuilder sb = new StringBuilder();
        for(char c : word.toLowerCase().toCharArray()){
           if(vowels.contains(c)){
            sb.append('*');
           }else{
            sb.append(c);
           }
           }

           return sb.toString();

     }
}