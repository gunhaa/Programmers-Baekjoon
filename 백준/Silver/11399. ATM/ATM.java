import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int iter = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final List<Integer> list = new ArrayList<>();
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < iter; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        ListIterator<Integer> iterator = list.listIterator();
        while(iterator.hasNext()) {
            int time = iterator.next();
            sum += time;
            answer += sum;
        }
        System.out.println(answer);
    }
}
