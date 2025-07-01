import java.util.*;
import java.io.*;

public class Main {
    static int x;
    static int y;
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static int startX;
    static int startY;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st1.nextToken());
        x = Integer.parseInt(st1.nextToken());
        map = new int[y][x];
        visited = new boolean[y][x];
//        System.out.println(Arrays.deepToString(map));
        for (int i = 0; i < y; i++) {
            String[] lines = br.readLine().split("");
            for (int j = 0; j < x; j++) {
                switch(lines[j]) {
                    case "O": {
                        // not necessary
                        map[i][j] = 0;
                        break;
                    }
                    case "P": {
                        map[i][j] = 2;
                        break;
                    }
                    case "X": {
                        map[i][j] = 1;
                        break;
                    }
                    case "I": {
                        map[i][j] = 0;
                        startX = j;
                        startY = i;
                        break;
                    }
                }
            }
        }
        bfs(startX, startY);
//        System.out.println("startX = " + startX);
//        System.out.println("startY = " + startY);
//        System.out.println(Arrays.deepToString(map));
//        System.out.println(Arrays.deepToString(visited));

        System.out.println(count != 0 ? count : "TT");
    }

    static void bfs(int sx, int sy) {
        visited[sy][sx] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sy, sx});
        while(!queue.isEmpty()) {

            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for(int i=0; i<dx.length; i++) {
                int mx = curX + dx[i];
                int my = curY + dy[i];

                if(mx >= 0 && my >= 0 && my < y && mx < x) {
                    if(!visited[my][mx] && (map[my][mx] == 0 || map[my][mx] == 2)) {
                        visited[my][mx] = true;
                        if(map[my][mx] == 2) {
                            count++;
                        }
                        queue.add(new int[]{my, mx});
                    }
                }
            }
        }

    }
}
