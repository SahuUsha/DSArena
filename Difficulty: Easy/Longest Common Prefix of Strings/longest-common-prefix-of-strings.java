class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here\
        
        
        Arrays.sort(arr);
        
        String first = arr[0];
        String last = arr[arr.length-1];
        StringBuilder str = new StringBuilder();
        
        for(int i = 0 ; i<first.length() ; i++){
            
            if(first.charAt(i)!=last.charAt(i)){
                return str.toString();
            }
            
            str.append(first.charAt(i));
        }
        
        return str.toString();
        
    }
}