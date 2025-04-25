import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<count; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Comparator.naturalOrder());
        System.out.println(Calculator.avg(list));
        System.out.println(Calculator.middleValue(list));
        System.out.println(Calculator.frequency(list));
        System.out.println(Calculator.difference(list));
    }

    static class Calculator {
        static int avg(List<Integer> list){
            int sum = 0;
            for(Integer d : list) {
                sum+= d;
            }

            return (int) Math.round((double) sum / list.size());
        }

        static int middleValue(List<Integer> list){
            int size = list.size();
            return list.get(size/2);
        }

        static int frequency(List<Integer> list){
            Set<Integer> listSet = Set.copyOf(list);
            if(listSet.size() == list.size()){
                if(list.size() == 1){
                    return list.get(0);
                }
                return list.get(1);
            } else {
                Map<Integer, Integer> map = new HashMap<>();
                for(Integer i : list){
                    if(!map.containsKey(i)){
                        map.put(i, 1);
                    } else {
                        Integer value = map.get(i);
                        map.put(i, value+1);
                    }
                }

                int max = 1;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if(max < entry.getValue()){
                        max = entry.getValue();
                    }
                }

                Set<Integer> answerSet = new HashSet<>();
                int key = 0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if(entry.getValue() == max) {
                        key = entry.getKey();
                        answerSet.add(key);
                    }
                }

                if(answerSet.size() == 1){
                    return key;
                } else {
                    if(list.size() == 1){
                        return list.get(0);
                    }
                    Integer result = answerSet.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()).get(1);

                    return result;
                }
            }
        }

        static int difference(List<Integer> list){
            int min = list.get(0);
            int max = list.get(list.size()-1);
            return Math.abs(max-min);
        }
    }
}
