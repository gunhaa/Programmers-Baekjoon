import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] resultMap;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int length;
    static int width;
    static BufferedWriter bw;
    static int startX;
    static int startY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        length = Integer.parseInt(st1.nextToken());
        width = Integer.parseInt(st1.nextToken());
        startX = -1;
        startY = -1;
        map = new int[length][width];
        resultMap = new int[length][width];
        visited = new boolean[length][width];
        for (int i = 0; i < length; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                int ground = Integer.parseInt(st2.nextToken());
                map[i][j] = ground;
                if (ground == 2) {
                    startX = j;
                    startY = i;
                }
            }
        }

        if (startX == -1 && startY == -1) {
            throw new IllegalStateException();
        }

        bfs(startX, startY);

        // 갈 수 없는 곳 -1
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if(!visited[i][j] && map[i][j] == 1){
                    resultMap[i][j] = -1;
                }
            }
        }
        printResult();
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[y][x] = true;
        resultMap[y][x] = 0;
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            for (int i = 0; i < dx.length; i++) {
                int my = curY + dy[i];
                int mx = curX + dx[i];

                if (mx >= 0 && my >= 0 && length > my && width > mx) {
                    if (!visited[my][mx] && map[my][mx] == 1) {
                        visited[my][mx] = true;
                        resultMap[my][mx] = resultMap[curY][curX] + 1;
                        queue.add(new int[]{my, mx});
                    }
                }
            }
        }
    }

    static void dfsR(int x, int y, int distance) {
        visited[y][x] = true;
        resultMap[y][x] = distance;

        for (int i = 0; i < dx.length; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if (mx >= 0 && my >= 0 && length > my && width > mx) {
                if (!visited[my][mx] && map[my][mx] == 1) {
                    dfsR(mx, my, distance + 1);
                }
            }
        }
    }

    static void printResult() throws IOException {
        for (int i = 0; i < resultMap.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < resultMap[i].length; j++) {
                if (j == resultMap[i].length - 1) {
                    sb.append(String.valueOf(resultMap[i][j]));
                    continue;
                }
                sb.append(String.valueOf(resultMap[i][j]) + " ");
            }
            bw.write(sb.toString() + "\n");
        }
        bw.flush();
        bw.close();
    }
}
