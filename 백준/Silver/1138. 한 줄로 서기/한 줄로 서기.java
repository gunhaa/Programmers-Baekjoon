import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());
        int[] people = new int[iter];
        int[] answer = new int[iter];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < iter; i++) {
            int left = Integer.parseInt(st.nextToken());
            people[i] = left;
        }
//        System.out.println(Arrays.toString(people));
        // people[idx] idx가 키 순서
        // 내 키번호(idx)를 이용함
        for (int i = 0; i < iter; i++) {
            // 나보다 큰 사람 수
            int count = 0;
            // 현재 idx
            int cnt = 0;
            int left = people[i];
            while(count < left || answer[cnt] != 0) {
                if(answer[cnt] == 0 ) {
                    count++;
                }
                cnt++;
            }

            while(answer[cnt] != 0) {
                cnt++;
            }
            answer[cnt] = i+1;
        }
        
        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
