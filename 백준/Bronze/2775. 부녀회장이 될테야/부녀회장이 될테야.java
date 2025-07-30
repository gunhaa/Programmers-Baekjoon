import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_FLOOR_AND_UNIT = 15;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        int[][] apartment = new int[MAX_FLOOR_AND_UNIT][MAX_FLOOR_AND_UNIT];
        // 0층 세팅
        for (int i = 0; i < MAX_FLOOR_AND_UNIT; i++) {
            apartment[0][i] = i;
        }
        // 0층부터 있다
        // 호수는 1호부터~14호까지
        // i 층
        for (int i = 1; i < MAX_FLOOR_AND_UNIT; i++) {
            // j 호수
            for (int j = 1; j < MAX_FLOOR_AND_UNIT; j++) {
                int tempSum = 0;
                // 사람을 구하기 위한 iter k
                for (int k = 1; k <= j; k++) {
                    tempSum += apartment[i-1][k];
                }
                apartment[i][j] = tempSum;
            }
        }

        for (int i = 0; i < tc; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(apartment[k][n]);
        }
//        System.out.println(Arrays.deepToString(apartment));
    }
}
