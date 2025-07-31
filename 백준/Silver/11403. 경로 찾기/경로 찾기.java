import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static int[][] result;
    static boolean[] visited;
    static int dfsResult = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        result = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 방법1. dfs/bfs
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfsR(i, i);
        }

//        System.out.println(Arrays.deepToString(result));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfsR(int start, int cur) {

        for (int next = 0; next < N; next++) {
            if (!visited[next] && graph[cur][next] == 1) {
                visited[next] = true;
                result[start][next] = 1;
                dfsR(start, next);
            }
        }
    }
}
