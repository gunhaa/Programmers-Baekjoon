import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] strlist) {
        List<Integer> list = new ArrayList<Integer>();

        for(String s : strlist){
            list.add(s.length());
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}