class Solution {
    public int finalValueAfterOperations(String[] operations) {
        String v1 = "++X";
        String v2 = "X++";
        String v3 = "--X";
        String v4 = "X--";
        int x = 0;


        for(int  i = 0 ; i <operations.length;i++){
            if(operations[i].equals(v1)){
                ++x;

            }else if(operations[i].equals(v2)){
                x++;
            }else if(operations[i].equals(v3)){
                --x;
            }else{
                x--;
            }
        }
        return x;
        
    }
}