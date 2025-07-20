import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] searchMax = new int[3];
        int[] searchMin = new int[3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cur0 = Integer.parseInt(st.nextToken());
            int cur1 = Integer.parseInt(st.nextToken());
            int cur2 = Integer.parseInt(st.nextToken());

//            System.out.println("cur0 = " + cur0);
//            System.out.println("cur1 = " + cur1);
//            System.out.println("cur2 = " + cur2);
            if (i == 0) {
                searchMax[0] = cur0;
                searchMax[1] = cur1;
                searchMax[2] = cur2;

                searchMin[0] = cur0;
                searchMin[1] = cur1;
                searchMin[2] = cur2;
            } else {
                int prevMax0 = searchMax[0];
                int prevMax1 = searchMax[1];
                int prevMax2 = searchMax[2];

                searchMax[0] = Math.max(prevMax0, prevMax1) + cur0;
                searchMax[1] = Math.max(prevMax0, Math.max(prevMax1, prevMax2)) + cur1;
                searchMax[2] = Math.max(prevMax1, prevMax2) + cur2;

                int prevMin0 = searchMin[0];
                int prevMin1 = searchMin[1];
                int prevMin2 = searchMin[2];

                searchMin[0] = Math.min(prevMin0, prevMin1) + cur0;
                searchMin[1] = Math.min(prevMin0, Math.min(prevMin1, prevMin2)) + cur1;
                searchMin[2] = Math.min(prevMin1, prevMin2) + cur2;
            }
//            System.out.println(Arrays.toString(searchMax));
//            System.out.println(Arrays.toString(searchMin));

        }

        int max = Integer.MIN_VALUE;
        for (int candidate : searchMax) {
            max = Math.max(candidate, max);
        }

        int min = Integer.MAX_VALUE;
        for(int candidate : searchMin) {
            min = Math.min(candidate, min);
        }
        System.out.println(max + " " + min);

//        System.out.println(Arrays.deepToString(grid));

    }
}
