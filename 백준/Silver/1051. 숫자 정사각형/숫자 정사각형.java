import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        int[][] rect = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String line = br.readLine();
            for (int j = 0; j < cols; j++) {
                rect[i][j] = line.charAt(j) - '0';
            }
        }

        int maxLen = 0;
        // 1. 가장 쉬운 방법 = 3중 루프
        // 2. 어려울거 같은데 될거같은 방법 = HashMap을 이용한 보충수로 탐색
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int searchNum = rect[i][j];
                for (int k = j+1; k < cols; k++) {
                    if(searchNum == rect[i][k]) {
                        int len = k-j;
                        if( i+len < rows && searchNum == rect[i+len][j] && searchNum == rect[i+len][k]) {
                            maxLen = Math.max(maxLen, len);
                        }
                    }
                }
            }
        }

        if(maxLen == 0) {
            System.out.println(1);
        } else {
            int len = maxLen + 1;
            System.out.println(len*len);
        }
    }

}
