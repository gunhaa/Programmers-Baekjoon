import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        int Z = (int)((100* Y/X));
        int answer = binarySearch(X, Y, Z);
        System.out.println(answer);
    }

    static int binarySearch(long X, long Y, int Z) {
        int left = 1;
        int right = 1000000001;
        int mid = 1;
        int answer = -1;

        while(left <= right){
            mid = (left + right) / 2;

            // 전체 게임 숫자는 mid이며, 졌다고 표현 가능한 게임은 X(최초 게임횟수)-Y(최초 이긴 게임) 이다
            // 목표승률(target)
            // 현재 검증 중인 승률 -> 이긴 게임 = mid + Y / 전체 게임 = mid + X
            int winRate = (int) (((mid + Y) * 100 / (mid + X)));
            if( winRate > Z){
                right = mid - 1;
                answer = right+1;
            } else {
                left = mid + 1;
                answer = left;
            }
        }

        if(mid == 1000000001){
            return -1;
        }
        // mid는 같은 승률을 유지하는 마지막 값, +1을 하게되면 최초 승률 변화 시점을 가져올 수 있다
        return answer;
    }
}
