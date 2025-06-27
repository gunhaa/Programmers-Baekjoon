import java.io.*;
import java.util.*;

public class Main {

    static int result = 0;
    static boolean[] visited;
    static List<Node> graph = new ArrayList<>();

    static class Node {
        LinkedList<Integer> linked = new LinkedList<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine());
        int iter = Integer.parseInt(br.readLine());

        visited = new boolean[computer + 1];
        for (int i = 0; i <= computer; i++) {
            graph.add(new Node());
        }

        for (int i = 0; i < iter; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int comFrom = Integer.parseInt(st.nextToken());
            int comTo = Integer.parseInt(st.nextToken());
            graph.get(comFrom).linked.add(comTo);
            graph.get(comTo).linked.add(comFrom);
        }
        dfsR(1);

        System.out.println(result);
    }

    static void dfsR(int start) {
        visited[start] = true;

        for(Integer nodeNo : graph.get(start).linked) {
            if(!visited[nodeNo]) {
                visited[nodeNo] = true;
                result++;
                dfsR(nodeNo);
            }
        }
    }
}
