import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<count; i++){
            int line = Integer.parseInt(br.readLine());
            if(line == 0) {
                if(pq.isEmpty()) {
                    System.out.println("0");
                } else {
                    Integer root = pq.poll();
                    System.out.println(root);
                }
            } else {
                pq.add(line);
            }
        }
    }
}
