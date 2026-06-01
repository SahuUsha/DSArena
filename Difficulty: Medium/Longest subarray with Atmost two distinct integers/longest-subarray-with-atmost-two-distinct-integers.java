class Solution {
    public int totalElements(int[] arr) {
        
        return distint(arr);
        
    }
    public int totalElements1(int[] arr) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxlen = 0;

        for (int right = 0; right < arr.length; right++) {

            
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

          
            while (map.size() > 2) {

                map.put(arr[left], map.getOrDefault(arr[left], 0) - 1);

                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }

                left++;
            }

            maxlen = Math.max(maxlen, right - left + 1);
        }

        return maxlen;
        
        
    }
    
    public static int distint(int[] arr){
        
        int l = 0 , r=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int MaxLen = 0;
        
        
       while(r<arr.length){
           
           
                map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

               
               while(map.size()>2){
                   
                   map.put(arr[l] , map.get(arr[l])-1);
                   
                   if(map.get(arr[l])==0){
                       map.remove(arr[l]);
                   }
                   
                   l++;
               }
           
           int len = r-l+1;
           MaxLen = Math.max(len, MaxLen);
           r++;
       }
       
       return MaxLen;
        
        
    }
    
    
}