import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        final int M = 1234567891;
        long power = 1;
        long result = 0;
        for (char c : str) {
            long cur = (long) c - 96;
            result += cur*power;
            power = (power * 31) % M;
        }
        System.out.println(result%M);
    }
}
