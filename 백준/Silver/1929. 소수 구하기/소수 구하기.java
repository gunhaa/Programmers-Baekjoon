import java.util.*;
import java.io.*;

public class Main {
    static boolean[] isPrime;
    static int start;
    static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        isPrime = new boolean[end + 1];
        for (int i = 2; i <= end; i++) {
            isPrime[i] = true;
        }

        validatePrime();

        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (isPrime[i]) {
                result.append(i).append("\n");
            }
        }

        System.out.println(result);
    }

    static void validatePrime() {
        for (int i = 2; i <= Math.sqrt(end); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= end; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

}
