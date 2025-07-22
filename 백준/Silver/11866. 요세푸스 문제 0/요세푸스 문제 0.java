import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken())-1;
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(i+1);
        }

        int curIdx = 0;
        while(!list.isEmpty()){
            curIdx += K;
            curIdx %= list.size();
            result.add(list.remove(curIdx));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < result.size(); i++) {
            if(i == result.size()-1) {
                sb.append(result.get(i)).append(">");
                break;
            }
            sb.append(result.get(i)).append(", ");
        }
        System.out.println(sb);
    }
}
