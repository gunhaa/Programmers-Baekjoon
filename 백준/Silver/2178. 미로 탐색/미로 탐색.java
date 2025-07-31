import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int N;
    static int M;
    static final int searchWays = 4;
    static final int startX = 0;
    static final int startY = 0;
    static int[] dx;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];
        dx = new int[]{1, -1, 0, 0};
        dy = new int[]{0, 0, 1, -1};

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

//        System.out.println(Arrays.deepToString(graph));
        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY, 1));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (int i = 0; i < searchWays; i++) {
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if(!visited[ny][nx] && nx == M-1 && ny == N-1 ) {
                        return curNode.depth+1;
                    }

                    if(!visited[ny][nx] && graph[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        queue.add(new Node(nx, ny, curNode.depth+1));
                    }
                }
            }
        }
        return -1;
    }

    static class Node {
        int x;
        int y;
        int depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
