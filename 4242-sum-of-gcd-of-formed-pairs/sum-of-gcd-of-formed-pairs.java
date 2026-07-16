class Solution {
    public long gcdSum(int[] nums) {

        long max = 0;
        long []prefixGcd = new long[nums.length];
        for(int i = 0 ;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            prefixGcd[i]= gcd(max,nums[i]);
        }

        Arrays.sort(prefixGcd);

        int i = 0 ;
        int j = nums.length-1;
        long sum =0;

        while(i<j && j>=0 && i<nums.length  ){
            sum += gcd(prefixGcd[i],prefixGcd[j]);
            i++;
            j--;
        }

        return sum;
    }

    public long gcd(long a, long b){
        while(b!=0){
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}