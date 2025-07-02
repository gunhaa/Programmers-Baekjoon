import java.util.*;
import java.io.*;

public class Main {
    static int len;
    static int[] list;
    static List<Integer> result = new ArrayList<>();
    static Set<String> duplicatedCheckSet = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int listLen = Integer.parseInt(st1.nextToken());
        len = Integer.parseInt(st1.nextToken());
        list = new int[listLen];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < listLen; i++) {
            list[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(list);
        back(0);
        System.out.println(sb);
    }

    static void back(int depth) {
        if(depth == len) {
            int[] temp = new int[len];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = result.get(i);
            }
            Arrays.sort(temp);
            if(duplicatedCheckSet.contains(Arrays.toString(temp))) {
                return;
            }
            duplicatedCheckSet.add(Arrays.toString(temp));
            for (int i = 0; i < temp.length; i++) {
                sb.append(Integer.valueOf(temp[i])).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < list.length; i++) {
            result.add(list[i]);
            back(depth + 1);
            result.remove(result.size()-1);
        }
    }
}
