class Solution {
    static List<Integer> get(int a, int b) {
        // code here
        List<Integer> list = new ArrayList<>();
        a = (a ^ b)^b;
        b = (a^b)^a;
        list.add(b);
        list.add(a);
        
        return list;
    }
}