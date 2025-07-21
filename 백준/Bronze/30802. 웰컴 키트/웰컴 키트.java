import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st2.nextToken());
        int P = Integer.parseInt(st2.nextToken());

        int shirtMaxOrder = 0;
        int penMaxOrderBundle = N/P;
        int penMaxOrderSingle = N%P;
        for (int i = 0; i < 6; i++) {
            int needShirts = Integer.parseInt(st1.nextToken());
            shirtMaxOrder += (int) Math.ceil((double) needShirts / T);
        }

        System.out.println(shirtMaxOrder);
        System.out.println(penMaxOrderBundle+ " " + penMaxOrderSingle);
    }
}
