import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int iter = Integer.parseInt(br.readLine());
        Queue<AbsHeap> pq = new PriorityQueue<>();
        for (int i = 0; i < iter; i++) {
            String line = br.readLine();
            if (line.equals("0")) {
                AbsHeap first = pq.poll();
                if (first == null) {
                    bw.write("0\n");
                } else {
                    bw.write(String.valueOf(first.element) + "\n");
                }
                continue;
            }
            pq.add(new AbsHeap(Integer.parseInt(line)));
        }
        bw.flush();
        bw.close();
    }

    static class AbsHeap implements Comparable<AbsHeap> {
        int element;

        public AbsHeap(int element) {
            this.element = element;
        }

        @Override
        public int compareTo(AbsHeap o) {
            int t1 = Math.abs(this.element);
            int t2 = Math.abs(o.element);

            if (t1 > t2) {
                return 1;
            }

            if (t1 == t2) {
                if (this.element > o.element) {
                    return 1;
                } else if (this.element == o.element) {
                    return 0;
                } else {
                    return -1;
                }
            }
            return -1;
        }
    }
}
