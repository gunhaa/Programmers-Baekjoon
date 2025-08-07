import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] countArr = new int[10001];
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            countArr[cur] += 1;
        }

        for (int i = 1; i < countArr.length; i++) {
            if(countArr[i] != 0) {
                for (int j = 0; j < countArr[i]; j++) {
                    bw.write(i+"\n");
                }
            }
        }
        bw.flush();
    }
}
