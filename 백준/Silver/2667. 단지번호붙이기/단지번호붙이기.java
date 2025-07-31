import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx;
    static int[] dy;
    static int depth = 1;
    static final int moveWays = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];
        dx = new int[]{1, -1, 0, 0};
        dy = new int[]{0, 0, 1, -1};

        for (int row = 0; row < N; row++) {
            String line = br.readLine();
            for (int col = 0; col < N; col++) {
                graph[row][col] = line.charAt(col) - '0';
            }
        }
//        System.out.println(Arrays.deepToString(graph));

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (graph[row][col] == 1 && !visited[row][col]) {
                    dfsR(col, row);
                    pq.offer(depth);
                    depth = 1;
                }
//                visited = new boolean[N][N];
            }
        }
        System.out.println(pq.size());
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    static void dfsR(int x, int y) {
        visited[y][x] = true;

        for (int i = 0; i < moveWays; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(!visited[ny][nx] && graph[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    depth++;
                    dfsR(nx, ny);
                }
            }
        }
    }
}
