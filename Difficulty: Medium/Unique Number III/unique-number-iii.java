class Solution {
	public int getSingle(int[] arr) {
		// code here
		
		int once =0;
		int twice =0;
		for(int num: arr){
		    once = (once ^ num ) & ~twice;
		    twice = (twice ^ num ) & ~once;
		}
		
		return once;
	
	}
}
