import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int top = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= top; i++) {
            dq.add(i);
        }

        while(dq.size() != 1) {
            dq.pollFirst();
            Integer first = dq.pollFirst();
            dq.offerLast(first);
        }
        System.out.println(dq.poll());
    }
}
