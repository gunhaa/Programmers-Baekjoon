import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            if (isGoodNumber(arr, i)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static boolean isGoodNumber(int[] arr , int targetIdx) {
        int leftIdx = 0;
        int rightIdx = arr.length-1;

        while (leftIdx < rightIdx) {

            if(leftIdx == targetIdx){
                leftIdx++;
                continue;
            }

            if(rightIdx == targetIdx){
                rightIdx--;
                continue;
            }

            int sum = arr[leftIdx] + arr[rightIdx];
            if (sum == arr[targetIdx]) {
                return true;
            } else if (sum < arr[targetIdx]) {
                leftIdx = leftIdx + 1;
            } else if (sum > arr[targetIdx]) {
                rightIdx = rightIdx - 1;
            }
        }
        return false;
    }
}
