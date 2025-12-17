class Solution {

    static final int MOD = 1_000_000_007;

    public int countHomogenous(String s) {
        int n = s.length();
        long ans =0;

        int l = 0;
        int r =0;

        while(r<n){

            while(r<n && s.charAt(r)==s.charAt(l)){
                r++;
            }

            long len = r-l;
             ans = (ans + len * (len + 1) / 2) % MOD;

             l = r;

        }
        return (int) ans;
    }
}