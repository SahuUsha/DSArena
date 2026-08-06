class Solution {
    public boolean canServe(int[] arr) {
        // code here
        
        int five = 0;
        int ten = 0 ;
        
        for(int i = 0 ; i<arr.length; i++){
            
            if(arr[i]==5){
                five++;
            }else if(arr[i]==10){
                if(five>0){
                    five--;
                    ten++;
                }else{
                    return false; 
                }
            }
            else if(arr[i]==20){
                if(five>0 && ten>0){
                    five--;
                    ten--;
                }else if(five>=3){
                    five -=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}