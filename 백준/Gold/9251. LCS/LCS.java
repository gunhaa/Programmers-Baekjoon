import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] strSeq1 = br.readLine().toCharArray();
        char[] strSeq2 = br.readLine().toCharArray();
        dp = new int[strSeq1.length+1][strSeq2.length+1];

        for (int i = 1; i <= strSeq1.length; i++) {
            for (int j = 1; j <= strSeq2.length; j++) {
                if(strSeq1[i-1] == strSeq2[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[strSeq1.length][strSeq2.length]);
    }
}
