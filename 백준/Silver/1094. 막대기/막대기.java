import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 64;

        int X = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        1. 이때, 합이 X보다 크다면, 아래와 같은 과정을 반복한다.
        pq.add(sum);

        while (sum > X) {
            //2. 가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
            Integer wood = pq.poll();
            int cutWood = wood / 2;
            pq.add(cutWood);
            //2-1. 만약, 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면, 위에서 자른 막대의 절반 중 하나를 버린다.
            int tempSum = 0;
            for (Integer w : pq) {
                tempSum += w;
            }

            if (tempSum < X) {
                pq.add(cutWood);
            }
            // 3. 이제, 남아있는 모든 막대를 풀로 붙여서 Xcm를 만든다.
            sum = 0;
            for (Integer w : pq) {
                sum += w;
            }
        }

        int count = pq.size();
        System.out.println(count);
    }
}
