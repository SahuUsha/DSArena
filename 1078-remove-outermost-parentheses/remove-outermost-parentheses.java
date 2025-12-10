class Solution {
    public String removeOuterParentheses(String s) {
        int len = s.length();
        if(len<=2) return "";
        StringBuilder newString = new StringBuilder();
        int open = 1;
        int openleft = 0;
        char[] c = s.toCharArray();
    
        for (int i = 1; i < len; i++) {
            if (c[i] == '(') {
                open++;
                if (open > 1) newString.append('(');
            }
            else {
                if (open > 1) newString.append(')');
                open--;
            }
        }
        return newString.toString();
    }
}