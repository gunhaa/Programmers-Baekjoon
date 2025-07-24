import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] results;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        results = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        dfs(1, 1);
        for (int i = 2; i < results.length; i++) {
            bw.write(results[i]+"\n");
        }
        bw.flush();
    }

    static void addEdge(int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    static void dfs(int depth, int parent){
        visited[depth] = true;
        results[depth] = parent;

        for(int next : graph.get(depth)) {
            if(!visited[next]) {
                dfs(next, depth);
            }
        }
    }
}
