class Solution {
    public int largestRectangleArea(int[] heights) {
        return maxArea(heights);
        
    }

    public int maxArea(int []heights){
        int Max = Integer.MIN_VALUE;
        Stack<Integer> idx = new Stack<>();
        Stack<Integer> value = new Stack<>();
        for(int i = 0 ;i<heights.length;i++){

            if(idx.isEmpty() && value.isEmpty()){
                idx.push(i);
                value.push(heights[i]);
            }

            while((!idx.isEmpty() && !value.isEmpty()) && heights[i] < value.peek() ){
             idx.pop();
               if(!idx.isEmpty()){
              Max = Math.max(Max , value.pop() * (i -idx.peek()-1));
             }else{
                    Max = Math.max(Max , value.pop() * (i -(-1)-1));

             }
            }

            idx.push(i);
            value.push(heights[i]);
        }

        while(!idx.isEmpty() && !value.isEmpty()){
             idx.pop();
             if(!idx.isEmpty()){
              Max = Math.max(Max , value.pop() * (heights.length -idx.peek()-1));
             }else{
                    Max = Math.max(Max , value.pop() * (heights.length -(-1)-1));

             }
        }
        return Max;


    } 
}