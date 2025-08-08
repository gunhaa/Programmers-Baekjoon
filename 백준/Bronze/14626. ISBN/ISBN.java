import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        char[] chars = line.toCharArray();
        int sum = 0;
        int multiplyN = -1;
        int starIdx = -1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '*') {
                if (i % 2 == 0) {
                    multiplyN = 1;
                } else {
                    multiplyN = 3;
                }
                starIdx = i;
                continue;
            }
            if (i % 2 == 0) {
                sum += chars[i] - '0';
                continue;
            }

            if (i % 2 == 1) {
                sum += (chars[i] - '0') * 3;
                continue;
            }
        }
        int m = chars[chars.length - 1] - '0';
        int target = (10 - (sum + m) % 10) % 10;

        int missing;
        if (multiplyN == 1) {
            missing = target;
        } else {
            missing = (target * 7) % 10;
        }

        System.out.println(missing);
    }
}
