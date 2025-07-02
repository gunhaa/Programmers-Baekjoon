import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int len;
    static int listLen;
    static Set<String> duplicatedCheckSet = new HashSet<>();
    static List<Integer> result = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        listLen = Integer.parseInt(st1.nextToken());
        len = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        visited = new boolean[listLen];
        for (int i = 0; i < listLen; i++) {
            list.add(Integer.parseInt(st2.nextToken()));
        }
        Collections.sort(list);

        back(0);
        System.out.println(sb);
    }


    static void back(int depth) {
        if (depth == len) {
            StringBuilder temp = new StringBuilder();
            for (int i : result) {
                temp.append(i).append(" ");
            }
            temp.append("\n");
            if(duplicatedCheckSet.contains(temp.toString())) {
                return;
            }
            sb.append(temp);
            duplicatedCheckSet.add(temp.toString());
            return;
        }

        for (int i = 0; i < listLen; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            result.add(list.get(i));
            back(depth + 1);
            result.remove(result.size() - 1);
            visited[i] = false;
        }
    }
}
