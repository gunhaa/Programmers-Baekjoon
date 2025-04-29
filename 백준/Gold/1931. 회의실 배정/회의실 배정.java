
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int count = Integer.parseInt(br.readLine());
        List<long[]> meetingList = new ArrayList<>();
        for (int i=0; i<count; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long h = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            meetingList.add(new long[]{h,m});
        }


        meetingList.sort((a, b) -> {
            if (a[1] == b[1]){
                return Long.compare(a[0], b[0]);
            }
            return Long.compare(a[1], b[1]);
        });

        long lastFinish = -1;
        for (long[] meeting : meetingList) {
            if(lastFinish > meeting[0]){
                continue;
            }

            lastFinish = meeting[1];
            answer++;
        }

        System.out.println(answer);
    }
}
