
import java.util.*;
import java.io.*;

public class Main {

    static final int cont = 10007;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int width = Integer.parseInt(br.readLine());
        // 2xn = f(n)의 총 방법수는
        // f(n) = f(n-2) + f(n-1)
        memo = new int[width+1];
        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= width; i++) {
            memo[i] = (memo[i-1] + memo[i-2]) % 10007;
        }

        System.out.println(memo[width]);
    }
}
