import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int[] arr = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int sum = 0;
        int pointerL = 0;
        int pointerR = 0;
        int answer = 0;

//        System.out.println(Arrays.toString(arr));
        // N개의 수열
        // 연속된 수열의 합 M
        while(pointerR <= arr.length) {
            if(sum == M) {
                answer++;
                sum -= arr[pointerL];
                pointerL++;
            } else if(sum > M) {
                sum -= arr[pointerL];
                pointerL++;
            } else if(sum < M) {
                if(pointerR == arr.length) {
                    while(pointerL < arr.length) {
                        if(sum == M) {
                            answer++;
                        }
                        sum -= arr[pointerL];
                        pointerL++;
                    }
                    break;
                }
                sum += arr[pointerR];
                pointerR++;
            }
        }

        System.out.println(answer);
    }

}
