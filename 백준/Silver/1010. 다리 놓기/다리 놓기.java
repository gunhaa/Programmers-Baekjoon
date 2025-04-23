import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int line = Integer.parseInt(br.readLine());

        for (int i = 0 ; i< line ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int result = combination(n, m);

            bw.write(String.valueOf(result));
            bw.write("\n");
            bw.flush();
        }
    }

    private static int[][] cache;

    private static int combination(int n, int m){
        cache = new int[n + 1][m + 1];
        return combinationRecursive(n, m);
    }

    private static int combinationRecursive(int n, int m){
        if(n==m || m == 0){
            return 1;
        }

        if(cache[n][m] != 0) {
            return cache[n][m];
        }

        cache[n][m] = combinationRecursive(n-1, m-1) + combinationRecursive(n-1, m);
        return cache[n][m];
    }

}
