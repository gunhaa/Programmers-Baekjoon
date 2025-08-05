import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx;
    static int[] dy;
    static int[][] prevGraph;
    static int iceCount = -1;
    static int years = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        graph = new int[N][M];
        dx = new int[]{1, -1, 0, 0};
        dy = new int[]{0, 0, 1, -1};

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        // 빙산 좌표 리스트 만들고 해당것만 iteration.. 더 효율적이긴 하지만 굳이? 이래도 시간 복잡도 괜찮을거같음
        // 빙산 녹이기

        while(true) {

            visited = new boolean[N][M];
            // graph를 전부 탐색하며 덩어리 판정
            iceCount = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && graph[i][j] > 0) {
                        dfsR(j, i);
                        iceCount++;
                    }
                }
            }

            if(iceCount >= 2) {
                System.out.println(years);
                return;
            }

            if(iceCount == 0) {
                System.out.println(iceCount);
                return;
            }

            years++;
            // 이전 그래프 복사
            prevGraph = new int[graph.length][];
            for (int i = 0; i < graph.length; i++) {
                prevGraph[i] = Arrays.copyOf(graph[i], graph[i].length);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (prevGraph[i][j] > 0) {
                        for (int k = 0; k < dx.length; k++) {
                            int nx = j + dx[k];
                            int ny = i + dy[k];
                            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                                if (prevGraph[ny][nx] == 0) {
                                    //1. 좌표에 따른 - 값을 모아놓은 후 batch처리
                                    //2. 이전 그래프 복사 한 후 이를 이용해 처리
                                    int melt = graph[i][j] - 1;
                                    graph[i][j] = Math.max(melt, 0);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static void dfsR(int x, int y) {
        visited[y][x] = true;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (!visited[ny][nx] && graph[ny][nx] > 0) {
                    dfsR(nx, ny);
                }
            }
        }
    }
}
