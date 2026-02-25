class Solution {
    public static int getMaxArea(int arr[]) {
        // code here
        return getMaxrec(arr);
    }
    
    public static int getMaxrec(int arr[]){
        
        Stack<Integer> idx = new Stack<>();
        Stack<Integer> value = new Stack<>();
        int max = Integer.MIN_VALUE;
        
        for(int i =0 ; i<arr.length ;i++){
            
            while((!idx.isEmpty() && !value.isEmpty()) && value.peek()>arr[i]){
                idx.pop();
                if(!idx.isEmpty()){
                    max = Math.max(max , value.pop()*(i-idx.peek()-1));
                }else{
                    max = Math.max(max , value.pop()*(i-(-1)-1));
                }
            }
            
            idx.push(i);
            value.push(arr[i]);
        }
        while((!idx.isEmpty() && !value.isEmpty())){
            idx.pop();
                if(!idx.isEmpty()){
                    max = Math.max(max , value.pop()*(arr.length-idx.peek()-1));
                }else{
                    max = Math.max(max , value.pop()*(arr.length-(-1)-1));
                }
        }
        return max;
    
    }
}
