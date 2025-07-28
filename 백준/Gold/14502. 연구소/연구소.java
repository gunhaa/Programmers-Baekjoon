import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static List<int[][]> candidatesList;
    static List<int[]> safeList;
    static List<int[]> virusList;
    static List<int[][]> createWallList;
    static int N;
    static int M;
    static int[] dx;
    static int[] dy;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        graph = new int[N][M];
        candidatesList = new ArrayList<>();
        safeList = new ArrayList<>();
        virusList = new ArrayList<>();
        createWallList = new ArrayList<>();

        dx = new int[]{1, -1, 0, 0};
        dy = new int[]{0, 0, 1, -1};

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        search();

        makeCombinationR(0, 0, new int[3][1]);

        System.out.println(max);
    }

    static void search() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    safeList.add(new int[]{i, j});
                } else if (graph[i][j] == 2) {
                    virusList.add(new int[]{i, j});
                }
            }
        }
    }

    static void simulateVirus(int[][] tempResult) {
        int[][] copyGraph = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyGraph[i] = Arrays.copyOf(graph[i], graph[i].length);
        }

        for (int[] wall : tempResult) {
            copyGraph[wall[0]][wall[1]] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int[] virus : virusList) {
            queue.offer(virus);
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(copyGraph[nx][ny] == 0) {
                        copyGraph[nx][ny] = 2;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copyGraph[i][j] == 0) {
                    count++;
                }
            }
        }


        max = Math.max(count, max);
        if(max == 32 && !flag) {
            System.out.println(Arrays.deepToString(tempResult));
            System.out.println(Arrays.deepToString(copyGraph));
            flag = true;
        }
    }
    static boolean flag = false;

    static void makeCombinationR(int start, int depth, int[][] tempResult) {
        if (depth == 3) {
            // 좌표를 이용한 bfs
            simulateVirus(tempResult);
            return;
        }

        for (int i = start; i < safeList.size(); i++) {
            tempResult[depth] = safeList.get(i);
            makeCombinationR(i + 1, depth + 1, tempResult);
        }
    }
}
