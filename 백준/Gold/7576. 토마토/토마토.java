import java.util.*;
import java.io.*;

public class Main {
    static int[][] box;
    static boolean[][] visited;
    static final int directions = 4;
    static int M;
    static int N;
    static int[] dx;
    static int[] dy;
    static List<Coordinate> ripeTomatoList = new LinkedList<>();
    static int unripeTomatoNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        visited = new boolean[N][M];
        dx = new int[]{1, -1, 0, 0};
        dy = new int[]{0, 0, 1, -1};

        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st1.nextToken());
                box[i][j] = value;
                if (value == 1) {
                    ripeTomatoList.add(new Coordinate(j, i));
                } else if (value == 0) {
                    unripeTomatoNum++;
                }
            }
        }
        int resultBfs = bfs();
        System.out.println(resultBfs);
    }

    static int bfs() {
        int days = 0;

        Queue<Coordinate> queue = new LinkedList<>(ripeTomatoList);

        // 익히기
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate cur = queue.poll();
                for (int j = 0; j < directions; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx >= 0 && ny >= 0 && ny < N && nx < M) {
                        if (box[ny][nx] == 0) {
                            box[ny][nx] = 1;
                            unripeTomatoNum--;
                            queue.add(new Coordinate(nx,ny));
                        }
                    }
                }
            }
            if (!queue.isEmpty()) {
                days++;
            }
        }
        return unripeTomatoNum == 0 ? days : -1;
    }

    static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
