class Solution {
    // Method to find the element with odd occurrence in given array
    int getOddOccurrence(int[] arr) {
        // code here
    //     HashSet<Integer> set = new HashSet<>();
        
    //     for(int i = 0 ; i<arr.length ; i++){
    //         if(set.contains(arr[i])){
    //             set.remove(arr[i]);
                
    //         }else{
    //             set.add(arr[i]);
    //         }
    //     }
       
    //   int ans = 0;
    //   for(int e : set){
    //       ans = e;
    //   }
    //     return ans;
    Arrays.sort(arr);
    
    int first = 0;
    int sec = 1;
    while((sec <=arr.length-2 )&& (arr[first]==arr[sec])){
        first +=2;
         sec +=2;
    //   System.out.println("second"+sec);
         
    }
    // System.out.println("fisrt"+first);
    return arr[first];
    
    }
}