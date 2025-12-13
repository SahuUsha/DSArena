class Solution {
    public boolean rotateString(String s, String goal) {

        return rotateString1(s,goal);

    }
    public static boolean rotateString1(String s , String goal){
      HashSet<String> set = new HashSet<String>();


      set.add(goal);

      // StringBuffer modstr = new StringBuffer(s);

      if(set.contains(s)){
        return true;
      }


      for(int i = 0 ; i <s.length() ; i++){
        s = s.substring(1,s.length()) + s.substring(0,1);
        if(set.contains(s)){
          return true;
        }
      }   


     return false;
}
}