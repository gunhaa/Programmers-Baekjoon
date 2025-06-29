import java.io.*;
import java.util.*;

public class Main {
    static int iter;
    static int stairsLen;
    static int[] stairs;
    static int max = Integer.MIN_VALUE;
    static int [][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        iter = Integer.parseInt(br.readLine());
        stairsLen = iter - 1;
        stairs = new int[301];
        memo = new int[301][3];
        for (int i = 0; i < iter; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // bottom up dp
        dpR(-1, 0, 0);
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    static void dpR(int start, int seq, int acc) {
        // 시작점을 제외하고, 이미 더 좋은 점수로 방문했다면 탐색할 필요 없음
        if (start != -1 && memo[start][seq] >= acc) {
            return;
        }

        // 메모에 현재까지 점수 저장 (더 큰 점수로만 갱신)
        if (start != -1) {
            memo[start][seq] = acc;
        }

        if (start == stairsLen) {
            max = Math.max(max, acc);
            return;
        }

        if (seq == 0 || seq == 1) {
            if (start + 1 <= stairsLen) {
                dpR(start + 1, seq + 1, acc + stairs[start + 1]);
            }
        }

        if(start + 2 <= stairsLen) {
            dpR(start + 2, 1, acc + stairs[start + 2]);
        }
    }
}
