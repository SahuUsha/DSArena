import java.util.*;

class Solution {

    static void sieve() {
       
    }

    static List<Integer> findPrimeFactors(int N) {

        int[] spf = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= N; i++) {
            if (spf[i] == i) { 
                for (int j = i * i; j <= N; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (N != 1) {
            result.add(spf[N]);
            N /= spf[N];
        }

        return result;
    }
}
