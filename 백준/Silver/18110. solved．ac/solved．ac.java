import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double round = Math.round(N * 0.15);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int line = Integer.parseInt(br.readLine());
            list.add(line);
        }
        Collections.sort(list);
        Deque<Integer> deque = new ArrayDeque<>(list);
        for (int i = 0; i < round; i++) {
            deque.removeFirst();
            deque.removeLast();
        }

        int sum = 0;
        for (int item : deque) {
            sum += item;
        }
        long result = Math.round((double) sum / deque.size());
        System.out.println(result);
    }
}
