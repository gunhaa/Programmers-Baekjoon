import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int[] results = new int[11];
        for (char c : line.toCharArray()) {
            int i = c - '0';
            results[i]++;
        }

        int counts = results[6]+results[9];
        double result = Math.ceil((double) counts / 2);
        results[6] = (int)result;
        results[9] = (int)result;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= 9; i++) {
            max = Math.max(results[i], max);
        }
        System.out.println(max);
    }

}
