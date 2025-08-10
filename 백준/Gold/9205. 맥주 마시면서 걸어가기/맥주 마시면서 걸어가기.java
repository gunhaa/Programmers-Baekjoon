import java.util.*;
import java.io.*;

public class Main {
    static final String HAPPY = "happy";
    static final String SAD = "sad";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            List<List<Integer>> graph = new ArrayList<>();
            List<Coordinate> building = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                building.add(new Coordinate(x, y));
            }

            for (int j = 0; j < building.size(); j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < building.size(); j++) {
                for (int k = 0; k < building.size(); k++) {
                    if (getManhattanDistance(building.get(j), building.get(k)) <= 1000) {
                        graph.get(j).add(k);
                        graph.get(k).add(j);
                    }
                }
            }

            boolean isHappy = isHappyFestivalBfs(building, graph);
            result.append(isHappy ? HAPPY : SAD).append("\n");
        }
        System.out.println(result);
    }

    static boolean isHappyFestivalBfs(List<Coordinate> building, List<List<Integer>> graph) {
        int start = 0;
        int end = building.size() - 1;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if(cur == end) {
                return true;
            }

            for (int node : graph.get(cur)) {
                if(!visited[node]) {
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }

        return false;
    }

    static int getManhattanDistance(Coordinate a, Coordinate b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    static class Coordinate {
        int x;
        int y;

        Coordinate(int curX, int curY) {
            this.x = curX;
            this.y = curY;
        }
    }
}
