import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        StringTokenizer st = new StringTokenizer(firstLine);
        int iter = Integer.parseInt(st.nextToken());
        int object = Integer.parseInt(st.nextToken());
        List<Integer> wallet = new ArrayList<>();
        for (int i = 0; i < iter; i++) {
            wallet.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        int acc = 0;
        int remain = object - sum;
        while(object != sum) {
            acc++;

            int walletSize = wallet.size();

            for(int i = walletSize-1; i >= 0; i--) {
                Integer coin = wallet.get(i);
                if(coin > remain) {
                    wallet.remove(coin);
                    continue;
                }

                sum += coin;
                remain -= coin;
                break;
            }
        }
        System.out.println(acc);
    }
}
