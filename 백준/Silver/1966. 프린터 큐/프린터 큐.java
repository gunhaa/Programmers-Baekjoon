import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());

        for (int i = 0; i < iter; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int queueLen = Integer.parseInt(st1.nextToken());
            int targetNo = Integer.parseInt(st1.nextToken());
            ArrayDeque<Document> queue = new ArrayDeque<>();
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int j = 0; j < queueLen; j++) {
                queue.add(new Document(Integer.parseInt(st2.nextToken()), targetNo == j));
            }

            int count = 0;
            while(!queue.isEmpty()) {
//                System.out.println(queue);



                Document cur = queue.pollFirst();
                int curLen = queue.size();
//                System.out.println("curLen = " + curLen);
                for (Document doc : queue) {
                    if(cur.priority < doc.priority) {
                        queue.add(cur);
                        break;
                    }
                }
//                System.out.println("queueSize: " + queue.size());

                if(curLen == queue.size()) {
                    // 무사히 소비 완료
                    count++;
                    if(cur.isTarget) {
                        break;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static class Document {
        boolean isTarget;
        int priority;

        Document(int priority, boolean isTarget) {
            this.isTarget = isTarget;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "priority: " + this.priority + ", isTarget: " + this.isTarget;
        }
    }
}
