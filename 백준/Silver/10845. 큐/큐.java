import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < iter; i++) {
            String line = br.readLine();

            if (line.startsWith("push")) {
                String arg = line.split(" ")[1];
                queue.offer(Integer.parseInt(arg));
                continue;
            }

            if (line.startsWith("pop")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                Integer first = queue.pollFirst();
                System.out.println(first);
                continue;
            }

            switch (line) {
                case "front": {
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    Integer old = queue.peekFirst();
                    System.out.println(old);
                    break;
                }
                case "back": {
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    Integer recent = queue.peekLast();
                    System.out.println(recent);
                    break;
                }
                case "size": {
                    System.out.println(queue.size());
                    break;
                }
                case "empty": {
                    if (queue.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                }
            }
        }
    }
}
