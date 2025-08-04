import java.util.*;
import java.io.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int N;
    static int[] dx;
    static int[] dy;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];
        dx = new int[]{1, -1, 0, 0};
        dy = new int[]{0, 0, 1, -1};

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                graph[i][j] = height;
            }
        }

        for (int rain = 0; rain < 100; rain++) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] > rain && !visited[i][j]) {
                        dfsR(i, j, rain);
                        count++;
                    }
                }
            }
            max = Math.max(count, max);
            visited = new boolean[N][N];
        }
        System.out.println(max);
    }

    static void dfsR(int x, int y, int rain) {
        visited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && graph[nx][ny] > rain) {
                    visited[nx][ny] = true;
                    dfsR(nx, ny, rain);
                }
            }
        }
    }
}
