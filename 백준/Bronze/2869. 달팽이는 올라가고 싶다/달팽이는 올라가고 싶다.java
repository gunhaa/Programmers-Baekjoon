import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
//        climbR(A,B,V);

        // 시간 초과
//        for(;;) {
//            curHeight += A;
//            count++;
//            if (V <= curHeight) {
//                break;
//            }
//            curHeight -= B;
//        }

        int realMove = A - B;
        int lastPos = V - A;

        double result = Math.ceil((double) lastPos / realMove);

        int answer = (int) result + 1;

        System.out.println(answer);
    }

    // stack이 너무 깊어져서 recursive 불가
//    static void climbR(int climbDistance, int dropDistance, int height) {
//        curHeight += climbDistance;
//        count++;
//        if(height <= curHeight) {
//            return;
//        }
//        curHeight -= dropDistance;
//        climbR(climbDistance, dropDistance, height);
//    }
}
