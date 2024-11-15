import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {

        String[] str = s.split("");
        List<String> answer = new ArrayList<>();
        List<String> memory = new ArrayList<>();
        for(int i = 0 ; i<str.length; i++ ){
            int index = answer.indexOf(str[i]);

            if(index > -1) {
                answer.remove(index);
                memory.add(str[i]);
            }else if(!memory.contains(str[i])){
                answer.add(str[i]);
            }

        }
        System.out.println("memory = " + memory);
        return answer.stream().sorted().collect(Collectors.joining(""));
    }
}