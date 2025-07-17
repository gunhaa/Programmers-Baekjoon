import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] grid;
    static boolean[][] visited;
    static int normalResult = 0;
    static int colorResult = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line[j];
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    normalResult++;
                    dfs(i, j, grid[i][j]);
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(grid[i][j] == 'G') {
                    grid[i][j] = 'R';
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    colorResult++;
                    dfs(i, j, grid[i][j]);
                }
            }
        }

        System.out.println(normalResult + " " + colorResult);
    }

    static void dfs(int x, int y, char cur) {

        if(x < 0 || x >= N || y < 0 || y >= N || visited[x][y] || cur != grid[x][y]) {
            return;
        }

        visited[x][y] = true;

        dfs(x + 1, y, cur);
        dfs(x - 1, y, cur);
        dfs(x, y + 1, cur);
        dfs(x, y - 1, cur);
    }


}
