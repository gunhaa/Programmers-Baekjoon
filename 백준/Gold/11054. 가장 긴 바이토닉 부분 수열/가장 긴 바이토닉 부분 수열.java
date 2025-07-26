import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] dpL = new int[N];
        int[] dpR = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < seq.length; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }


        // 해당 idx까지 증가하는 경우 dpL
        for (int i = 0; i < seq.length; i++) {
            dpL[i] = 1;
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) {
                    dpL[i] = Math.max(dpL[i], dpL[j] + 1);
                }
            }
        }

        // 해당 idx이후 내려가는 경우 dpR
        for (int i = seq.length - 1; i >= 0; i--) {
            dpR[i] = 1;
            for (int j = seq.length - 1; j > i; j--) {
                if(seq[j] < seq[i]) {
                    dpR[i] = Math.max(dpR[i], dpR[j] +1);
                }
            }
        }


        int result = Integer.MIN_VALUE;
        for (int i = 0; i < dpR.length; i++) {
            result = Math.max(result, dpR[i] + dpL[i] - 1);
        }
        System.out.println(result);

    }
}
