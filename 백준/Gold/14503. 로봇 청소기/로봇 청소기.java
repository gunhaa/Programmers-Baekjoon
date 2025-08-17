import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;

    static int[] dx;
    static int[] dy;
    static int[][] graph;
    static boolean[][] visited;

    static int count = 0;
    static Robot robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, 1, 0, -1};

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        visited = new boolean[N][M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int robotX = Integer.parseInt(st2.nextToken());
        int robotY = Integer.parseInt(st2.nextToken());
        int direction = Integer.parseInt(st2.nextToken());
        robot = new Robot(robotX, robotY, direction);

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st3.nextToken());
            }
        }

        while (true) {
            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다
            if (!visited[robot.curX][robot.curY]) {
                visited[robot.curX][robot.curY] = true;
                count++;
            }
            // 현재 칸의 주변
            if (isMovable(robot)) {
                // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                // 반시계 방향으로 90도 회전한다.
                // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                // 1번으로 돌아간다.(continue)
                for (int i = 0; i < 4; i++) {
                    int rotateDirection = (robot.direction + 3) % 4;
                    robot.direction = rotateDirection;
                    int nx = robot.curX + dx[robot.direction];
                    int ny = robot.curY + dy[robot.direction];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if (graph[nx][ny] == 0 && !visited[nx][ny]) {
                            robot.curX = nx;
                            robot.curY = ny;
                            break;
                        }
                    }
                }
            } else {
                // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
                // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                // 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                int backDirection = (robot.direction + 2) % 4;
                int nx = robot.curX + dx[backDirection];
                int ny = robot.curY + dy[backDirection];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (graph[nx][ny] == 0) {
                        robot.curX = nx;
                        robot.curY = ny;
                    } else {
                        System.out.println(count);
                        return;
                    }
                } else {
                    System.out.println(count);
                    return;
                }
            }
        }

    }

    static boolean isMovable(Robot robot) {
        for (int i = 0; i < 4; i++) {
            int nx = robot.curX + dx[i];
            int ny = robot.curY + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (graph[nx][ny] == 0 && !visited[nx][ny]) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Robot {
        int curX;
        int curY;
        int direction;

        Robot(int curX, int curY, int direction) {
            this.direction = direction;
            this.curX = curX;
            this.curY = curY;
        }

    }
}
