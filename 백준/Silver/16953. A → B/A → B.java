import java.util.*;
import java.io.*;

public class Main {
    static Queue<Operand> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int min = bfs(A, B);
        System.out.println(min);
    }

    static int bfs(int start, int target) {
        queue.add(new Operand(start, 1));
        while(!queue.isEmpty()) {
            Operand cur = queue.poll();
            if(cur.value == target) {
                return cur.count;
            }
            if(cur.value > target) {
                continue;
            }
            int count = cur.count+1;
            long planA = cur.value*2;
            long planB = cur.value*10 + 1;

            queue.add(new Operand(planA, count));
            queue.add(new Operand(planB, count));
        }
        return -1;
    }

    static class Operand {
        long value;
        int count;

        public Operand(long value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
