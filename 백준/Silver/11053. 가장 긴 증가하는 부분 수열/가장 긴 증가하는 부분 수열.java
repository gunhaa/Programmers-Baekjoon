
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] seq = new int[iter];
        int[] memo = new int[iter];

        for (int i = 0; i < iter; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < seq.length; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                // j번째 원소가 i번째 원소보다 작다 && i번째 dp가 j번째 dp+1 값보다 작다
                if(seq[j] < seq[i] && memo[j] + 1 > memo[i]) {
                    memo[i] = memo[j] + 1;
                }
            }
        }

//        System.out.println(Arrays.toString(memo));
//        System.out.println(memo[memo.length-1]);
        int max = 0;
        for (int len : memo) {
            max = Math.max(max, len);
        }
        System.out.println(max);
    }
}
