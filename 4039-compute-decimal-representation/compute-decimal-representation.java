class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> ls = new ArrayList<>();

        int len = String.valueOf(n).length();  
        int place = (int) Math.pow(10, len - 1);

        while (place > 0) {
            int digit = n / place;
            if (digit != 0) {
                ls.add(digit * place);
            }
            n = n % place;
            place /= 10;
        }

       
        int[] res = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            res[i] = ls.get(i);
        }
        return res;
    }
}
