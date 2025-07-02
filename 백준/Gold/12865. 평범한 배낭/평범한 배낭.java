import java.util.*;
import java.io.*;

public class Main {
//    static int max = 0;
    static int iter;
    static int limit;
    static int[][] knapsack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        iter = Integer.parseInt(st1.nextToken());
        limit = Integer.parseInt(st1.nextToken());
        //knapsack[물건번호][0= 무게,1= 가치]
        knapsack = new int[iter+1][2];
        for (int i = 1; i <= iter; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            knapsack[i] = new int[]{Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())};
        }

        // dp[물건종류][무게제한]
        int[][] dp = new int[iter+1][limit+1];

        // 물건 종류
        for (int i = 1; i <= iter; i++) {
            // 무게별
            for (int j = 1; j <= limit; j++) {
                // 현재 물건의 무게가 배낭의 현재 무게 j보다 크면 넣을 수 없으므로,
                // 이전 물건(i-1)까지 고려했을 때의 결과를 그대로 가져온다.
                if(knapsack[i][0] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 현재 물건을 넣을 수 있다면,
                    // 1. 현재 물건을 넣지 않는 경우 (dp[i-1][j])
                    // 2. 현재 물건을 넣는 경우 (dp[i-1][j - knapsack[i][0]] + knapsack[i][1])
                    // 두 경우 중 더 큰 가치를 선택한다.
                                                        // [j - knapsack[i][0]: 현재 물건을 넣고 나면 남는 배낭의 남은 무게
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - knapsack[i][0]] + knapsack[i][1] );
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));

//        System.out.println(Arrays.deepToString(knapsack));
//        back(0, 0, 0);
        System.out.println(dp[iter][limit]);
    }

//    static void back(int startIdx, int accW, int accV) {
//        if(accW > limit) {
//            int prevAccV = accV - knapsack[startIdx-1][1];
//            max = Math.max(max, prevAccV);
//            return;
//        } else if(startIdx == knapsack.length) {
//            max = Math.max(max, accV);
//            return;
//        }
//
//        for (int i = startIdx; i < knapsack.length; i++) {
//            back(i+1 , accW + knapsack[i][0], accV + knapsack[i][1]);
//        }
//    }
}
