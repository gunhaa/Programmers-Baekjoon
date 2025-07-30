import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    static int[][] triangle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        triangle = new int[N][N];
        dp = new int[N][N];

        int count = 1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < count; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
            count++;
        }

//        System.out.println(Arrays.deepToString(triangle));

        for (int i = 0; i < N; i++) {
            dp[N-1][i] = triangle[N-1][i];
        }

        int count2 = 1;
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < N-count2; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
            count2++;
        }
//        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[0][0]);
    }
}
