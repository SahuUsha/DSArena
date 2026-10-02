class Solution {
    public int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int l = 0;
        int r = 0;

        int maxLen = Integer.MIN_VALUE;

 

        while(l<fruits.length && r<fruits.length){

            map.put(fruits[r], map.getOrDefault(fruits[r],0)+1);

            while(map.size()>2){

                map.put(fruits[l], map.get(fruits[l])-1);

                if(map.get(fruits[l])==0){
                    map.remove(fruits[l]);
                }
                l++;
            }

          maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        
     return maxLen;
    }
}