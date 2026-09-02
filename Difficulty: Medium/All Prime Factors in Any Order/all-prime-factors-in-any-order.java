class Solution {
    ArrayList<Integer> primeFactors(int n) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {

            while (n % i == 0) {
                list.add(i);
                n = n / i;
            }
        }

        // If n is still > 1, it is a prime factor
        if (n > 1) {
            list.add(n);
        }

        return list;
    }
}