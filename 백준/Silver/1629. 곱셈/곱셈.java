import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long result = fastPowR(A, B, C);
        System.out.println(result);
    }

    static long fastPowR(long base, long exponent, long modulus) {

        if (exponent == 1) {
            return base % modulus;
        }

        long tempResult = fastPowR(base, exponent / 2, modulus);

        if (exponent % 2 == 1) {
            return (tempResult * tempResult % modulus) * base % modulus;
        }

        return tempResult * tempResult % modulus;
    }
}
