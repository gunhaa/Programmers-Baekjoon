import java.util.*;
import java.io.*;

public class Main {
    static char[][] graph;
    static boolean[][] visited;
    static int maxMove;
    static int R;
    static int C;
    static Set<Character> status = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                graph[i][j] = chars[j];
            }
        }

        dfs(0,0, 1);

        System.out.println(maxMove);
    }

    static void dfs(int x, int y, int acc) {
//        System.out.println("visited x: " + x + ", y: " + y);
//        System.out.println("graph[x][y]: " + graph[x][y]);
//        System.out.println(status);
        if(x < 0 || x >= R || y < 0 || y >= C || status.contains(graph[x][y])){
//            System.out.println("현재 이곳이 실행되면 안되는데?");
            maxMove = Math.max(acc-1, maxMove);
            return;
        }

        status.add(graph[x][y]);

        dfs(x+1, y, acc+1);
        dfs(x-1, y, acc+1);
        dfs(x, y+1, acc+1);
        dfs(x, y-1, acc+1);

        status.remove(graph[x][y]);

    }
}
