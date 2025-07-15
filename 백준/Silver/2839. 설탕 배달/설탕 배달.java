import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int W = Integer.parseInt(br.readLine());
        int[] weights = new int[W + 1];
        Arrays.fill(weights, 5001);
        weights[0] = 0;

        for (int i = 3; i < weights.length; i++) {
            if(weights[i-3] != 5001) {
                weights[i] = weights[i-3]+1;
            }
        }

        for (int i = 5; i < weights.length; i++) {
            if(weights[i-5] != 5001) {
                weights[i] = Math.min(weights[i-5]+1, weights[i]);
            }
        }

        if(weights[W] == 5001) {
            System.out.println(-1);
        } else {
            System.out.println(weights[W]);
        }
    }
}
