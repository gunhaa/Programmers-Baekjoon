
import java.util.*;
import java.io.*;

public class Main {

    static int iter;
    static int select;
    static StringBuilder sb = new StringBuilder();
    static int[] sequence;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        iter = Integer.parseInt(st.nextToken());
        select = Integer.parseInt(st.nextToken());
        sequence = new int[iter+1];
        for (int i = 1; i < sequence.length; i++) {
            sequence[i] = i;
        }

        back(1, 0);
//        System.out.println(Arrays.toString(sequence));
        System.out.println(sb);
    }

    static void back(int start, int depth) {
        if(depth == select) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < sequence.length; i++) {
            result.add(sequence[i]);
            back(i, depth+1);
            result.remove(result.size()-1);
        }
    }

}
