import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int iter = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < iter; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        for (Point p : list) {
            bw.write(String.valueOf(p.x) +" ");
            bw.write(String.valueOf(p.y));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }


    static class Point implements Comparable<Point>{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(this.x > o.x) {
                return 1;
            }

            if(this.x == o.x) {
                if(this.y > o.y) {
                    return 1;
                }

                if(this.y < o.y) {
                    return -1;
                }

                return 0;
            }

            return -1;
        }
    }
}
