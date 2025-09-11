class Solution {
    public String sortVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        List<Integer> idx = new ArrayList<>();
        List<Character> arr = new ArrayList<>();

        for(int i = 0 ;i<str.length(); i++){
                if(Character.toLowerCase(s.charAt(i))=='a' || Character.toLowerCase(s.charAt(i))=='e' || Character.toLowerCase(s.charAt(i))=='i' || Character.toLowerCase(s.charAt(i))=='o' || Character.toLowerCase(s.charAt(i))=='u'){
                    idx.add(i);
                    arr.add(str.charAt(i));
                }
        }
        Collections.sort(arr);
        int idxn=0;

        for(int i : idx){
            char ch = arr.get(idxn++);
            str.setCharAt(i, ch);
        }


        return str.toString();

    }
}