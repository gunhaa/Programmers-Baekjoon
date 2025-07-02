
import java.io.*;
import java.util.*;

public class Main {
    static int len;
    static int listLen;
    static List<Integer> result = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        listLen = Integer.parseInt(st1.nextToken());
        len = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < listLen; i++) {
            list.add(Integer.parseInt(st2.nextToken()));
        }
        Collections.sort(list);

        back(list.get(0), 0);
        System.out.println(sb);
    }

    static void back(int start, int depth) {
        if (depth == len) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < listLen; i++) {
            if(result.contains(list.get(i))) {
                continue;
            }
            result.add(list.get(i));
            back(i + 1, depth + 1);
            result.remove(result.size() - 1);
        }
    }
}
