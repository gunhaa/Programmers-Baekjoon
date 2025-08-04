import java.util.*;
import java.io.*;

public class Main {
    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static boolean[] visited;
    static final String impossible = "use the stairs";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new boolean[F+1];

        bfs();
    }

    static void bfs() {

        Queue<Floor> queue = new LinkedList<>();
        queue.add(new Floor(S, 0));
        while(!queue.isEmpty()) {
            Floor cur = queue.poll();
            if(cur.floor == G) {
                System.out.println(cur.depth);
                return;
            }

            int moveUp = cur.floor+U;
            int moveDown = cur.floor-D;
            if(moveUp <= F) {
                if(!visited[moveUp]) {
                    visited[moveUp] = true;
                    queue.add(new Floor(moveUp, cur.depth+1));
                }
            }

            if(moveDown >= 1) {
                if(!visited[moveDown]) {
                    visited[moveDown] = true;
                    queue.add(new Floor(moveDown, cur.depth+1));
                }
            }
        }
        System.out.println(impossible);
    }

    static class Floor {
        int floor;
        int depth;

        public Floor(int floor, int depth) {
            this.floor = floor;
            this.depth = depth;
        }
    }
}
