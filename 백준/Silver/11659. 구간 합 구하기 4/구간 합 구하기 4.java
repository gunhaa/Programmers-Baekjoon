import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st1.nextToken());
        int iter = Integer.parseInt(st1.nextToken());
        int[] nums = new int[len];
        int[] cache = new int[100001];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(st2.nextToken());
        }
//        System.out.println(Arrays.toString(nums));

        int sum = 0;
        for (int i = 1; i < nums.length+1; i++) {
            sum += nums[i-1];
            cache[i] += sum;
        }

//        System.out.println(Arrays.toString(cache));

        for (int i = 0; i < iter; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st3.nextToken()) - 1;
            int end = Integer.parseInt(st3.nextToken());
            // cache[end] - cache[start] , 0이라면 갱신
            int result = cache[end] - cache[start];
            bw.write(String.valueOf(result)+"\n");
        }
        bw.flush();
        bw.close();
    }
}