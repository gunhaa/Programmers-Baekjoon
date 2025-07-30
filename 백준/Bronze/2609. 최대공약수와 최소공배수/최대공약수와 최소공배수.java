import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (a < b) {
            // a > b가 아니라면 swap
            int temp = a;
            a = b;
            b = temp;
        }
        int gcdResult = gcdR(a, b);
        System.out.println(gcdResult);
        System.out.println(a*b/gcdResult);
    }

    static int gcdR(int a, int b) {
        int r = a % b;
        if(r == 0) {
            return b;
        }
        return gcdR(b,r);
    }
}
