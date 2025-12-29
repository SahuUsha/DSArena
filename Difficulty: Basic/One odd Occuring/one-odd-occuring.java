class Solution {
    // Method to find the element with odd occurrence in given array
    int getOddOccurrence(int[] arr) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i<arr.length ; i++){
            if(set.contains(arr[i])){
                set.remove(arr[i]);
                
            }else{
                set.add(arr[i]);
            }
        }
       
       int ans = 0;
       for(int e : set){
           ans = e;
       }
        return ans;
    }
}