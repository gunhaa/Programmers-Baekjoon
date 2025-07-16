import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Coordinate> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Coordinate c = new Coordinate(x, y);
            list.add(c);
        }
        Collections.sort(list);
        for (Coordinate c : list) {
            System.out.println(c.x + " " + c.y);
        }
    }

    static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.y - o.y > 0) {
                return 1;
            } else if (this.y == o.y) {
                if (this.x - o.x > 0) {
                    return 1;
                } else if (this.x - o.x < 0) {
                    return -1;
                }
                return 0;
            }
            
            return -1;
        }
    }
}
