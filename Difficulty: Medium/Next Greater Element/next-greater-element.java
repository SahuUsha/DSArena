class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        ArrayList <Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        stack.push(arr[n-1]);
        result.add(-1);
    
        
        
        for (int i = n - 2; i >= 0; i--) {

         
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }

            stack.push(arr[i]);
        }

        Collections.reverse(result);
        return result;
    }
}