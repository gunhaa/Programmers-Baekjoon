import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken())-1;
//        int[] circle = new int[N];
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        // circle[idx] idx+1 = 사람숫자
        for (int i = 0; i < N; i++) {
//            circle[i] = i+1;
            list.add(i+1);
        }
//        System.out.println(list);
//        System.out.println(Arrays.toString(circle));
        int cnt = 0;
        while(!list.isEmpty()) {
            cnt += K;
            cnt %= list.size();
            result.add(list.get(cnt));
            list.remove(cnt);
        }
//        System.out.println(list);
//        System.out.println(result);
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < result.size(); i++) {
            if(i==result.size()-1){
                sb.append(result.get(i)).append(">");
                break;
            }
            sb.append(result.get(i)).append(", ");
        }
        System.out.println(sb);
    }
}
