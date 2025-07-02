
import java.util.*;
import java.io.*;

public class Main {
    static int len;
    static StringBuilder sb = new StringBuilder();
    static int[] list;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int iter = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());

        list = new int[iter+1];
        for (int i = 1; i <= iter; i++) {
            list[i] = i;
        }
//        System.out.println(Arrays.toString(list));

        back(1, 0);
        System.out.println(sb);
    }

    static void back(int start, int depth) {
        if(depth == len) {
            for (int item : result) {
                sb.append(item).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < list.length; i++) {
            result.add(list[i]);
            back(i+1, depth+1);
            result.remove(result.size()-1);
        }
    }
}
