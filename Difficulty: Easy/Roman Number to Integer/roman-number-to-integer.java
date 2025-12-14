class Solution {
    public int romanToDecimal(String s) {
        // code here
        HashMap<Character, Integer> roaman = new HashMap<>();
        roaman.put('I',1);
        roaman.put('V',5);
        roaman.put('X',10);
        roaman.put('L',50);
        roaman.put('C',100);
        roaman.put('D',500);
        roaman.put('M',1000);
        
        int length = s.length();
        int total = 0;
        
        
        for(int i=0; i<s.length(); i++){
            
            
            int currentValue = roaman.get(s.charAt(i));
            if(i+1<length && roaman.get(s.charAt(i+1))>currentValue){
                total -= currentValue;
            }else{
                total += currentValue;
            }
        }
        
        
        return total;
        
        
    }
}