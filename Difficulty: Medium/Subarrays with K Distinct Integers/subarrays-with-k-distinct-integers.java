class Solution {
    
     public int exactlyK(int arr[], int k) {
         return exactlyK1(arr,k) - exactlyK1(arr,k-1);
     }
    
    public int exactlyK1(int arr[], int k) {
        // code here
        
        int l =0, r=0;
        int countSub = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        while(l<arr.length && r<arr.length){
            
            map.put(arr[r], map.getOrDefault(arr[r],0)+1);
            
            while(map.size()>k){
                
                map.put(arr[l], map.get(arr[l])-1);
                
                if(map.get(arr[l])==0){
                    map.remove(arr[l]);
                }
                
                l++;
            }
            
            
            countSub += r-l+1;
            
            r++;
        }
            
       
        
        return countSub;
        
    }
}
