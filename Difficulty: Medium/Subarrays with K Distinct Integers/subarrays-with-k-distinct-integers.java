// User function Template for Java

class Solution {
    static int exactlyK(int arr[], int k) {
        // code here
        return exactlykint(arr,k-1) - exactlykint(arr,k);
        
    }
    
    public  static int exactlykint(int arr[] , int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum =0;
        
        int l=0 ,r=0;
        while(r<arr.length){
            
            map.put(arr[r] , map.getOrDefault(arr[r],0)+1);
            
            while(map.size()>k){
                map.put(arr[l],map.get(arr[l])-1);
                
                if(map.get(arr[l])==0){
                    map.remove(arr[l]);
                }
                l++;
            }
            
            sum +=l-r+1;
            r++;
        }
        return sum;
    }
}
