import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String my_str, int n) {
        
        List<String> list = new ArrayList<String>();

        StringBuilder sb = new StringBuilder(my_str);

        while(sb.length()!=0){
            String temp;
            if(n >= sb.length()){
                temp = sb.substring(0,sb.length());
                sb.delete(0, sb.length());
            } else {
                temp = sb.substring(0, n);
                sb.delete(0,n);
            }
            list.add(temp);
        }
        System.out.println(list);
        return list.stream().toArray(String[]::new);
    }
}