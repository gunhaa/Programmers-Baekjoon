import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<count; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        long max = -1;
        for(Integer i : list){
            if(i > max){
                max = i;
            }
        }

        long start = 1;
        long answer = 0;
        while(start <= max){
            long mid = start + (max - start) / 2;
            long lanCount = lanCount(list, mid);

            if(lanCount < target){
                max = mid - 1;
            } else {
                start = mid + 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }

    private static int lanCount(List<Integer> list, long mid){
        int count = 0;
        for (Integer i : list) {
            long lan = i/mid;
            count += lan;
        }
        return count;
    }
}