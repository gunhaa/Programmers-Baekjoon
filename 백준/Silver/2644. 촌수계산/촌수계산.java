import java.util.*;
import java.io.*;

public class Main {
    static Graph graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new Graph(n);
        visited = new boolean[n + 1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st1.nextToken());
        int to = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
//            System.out.println("addEdge - a: " + a + ", b: " + b);
            graph.addEdge(a, b);
        }

//        System.out.println("from = " + from);
//        System.out.println("to = " + to);

        int bfsResult = bfs(from, to);
        System.out.println(bfsResult);
    }

    static int bfs(int from, int to) {
        int depth = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        visited[from] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();

                if(cur == to) {
                    return depth;
                }

                List<Integer> list = graph.edges.get(cur);
                for(int neighbor : list) {

                    if(!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            depth++;
        }
        return -1;
    }

    static class Graph {
        List<List<Integer>> edges;

        public Graph(int edgesNum) {
            this.edges = new LinkedList<>();
            for (int i = 0; i < edgesNum + 1; i++) {
                this.edges.add(new LinkedList<>());
            }
        }

        void addEdge(int a, int b) {
            edges.get(a).add(b);
            edges.get(b).add(a);
        }
    }
}
