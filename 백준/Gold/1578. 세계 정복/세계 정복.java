import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Integer> countryList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int countryNum = Integer.parseInt(st2.nextToken());
            countryList.add(countryNum);
        }

        Collections.sort(countryList);

        // 인구수가 최대 10억, log N 혹은 그 이하의 알고리즘 필요
        // 이진 탐색으로 말이 되는 최대 그룹을 찾는다
        long answer = binarySearch(countryList, K);

        System.out.println(answer);
    }

    static long binarySearch(List<Integer> countryList, int K){

        long left = 1;
        long right = 50000000001L;
        long answer = 0;

        while (left <= right){
            // mid 값은 그룹당 필요한 사람의 숫자
            long mid = (left + right) / 2;

            boolean result = canGroup(countryList, K, mid);
            // 최대값 탐색
            if(result) {
                left = mid + 1;
                // 맞는 위치로 갱신시킨다
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    static boolean canGroup(List<Integer> countryList, int K, long mid) {
        long peopleCount = 0;
        
        // 각 그룹에서 가능한 숫자를 모두 모은다
        for (Integer i : countryList) {
            long min = Math.min(mid, i);
            peopleCount += min;
        }
        
        // 필요한 사람보다 많은지 판정한다
        if((long) mid *K <= peopleCount){
            return true;
        } else {
            return false;
        }
    }
}
