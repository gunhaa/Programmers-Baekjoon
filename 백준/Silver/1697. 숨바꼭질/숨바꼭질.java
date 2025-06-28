import java.io.*;
import java.util.*;

public class Main {
    static int subin;
    static int brother;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());
        bfs(subin);
        System.out.println(min);

    }

    static void bfs(int location) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(location, 0));
        boolean[] visited = new boolean[100001];

        while (!queue.isEmpty()) {
            Node loc = queue.poll();
            if(loc.location == brother) {
                min = loc.depth;
                return;
            }

            visited[loc.location] = true;
            int[] nextLocArr = {loc.location + 1, loc.location - 1, loc.location * 2};
            for(int nextLoc : nextLocArr) {
                if(nextLoc <= 100000 && nextLoc >= 0 && !visited[nextLoc]) {
                    queue.offer(new Node(nextLoc, loc.depth+1));
                }
            }
        }
    }

    static class Node {
        int location;
        int depth;

        public Node(int location, int depth) {
            this.location = location;
            this.depth = depth;
        }
    }
}
