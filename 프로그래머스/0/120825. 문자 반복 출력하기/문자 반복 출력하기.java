class Solution {
    public String solution(String my_string, int n) {
        
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<my_string.length(); i++){
            String temp = String.valueOf(my_string.charAt(i)).repeat(n);
            sb.append(temp);
        }

        return sb.toString();
        
    }
}