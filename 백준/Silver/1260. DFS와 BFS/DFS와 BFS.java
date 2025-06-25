import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        class Graph {

            Node[] nodes;

            class Node implements Comparable<Node>{
                int data;
                boolean marked;
                LinkedList<Node> adj;

                public Node(int data) {
                    this.data = data;
                    this.marked = false;
                    this.adj = new LinkedList<>();
                }

                @Override
                public String toString() {
                    return String.valueOf(data);
                }


                @Override
                public int compareTo(Node o) {
                    return data-o.data;
                }
            }

            Graph(int size) {
                this.nodes = new Node[size + 1];
                for (int i = 1; i < size + 1; i++) {
                    nodes[i] = new Node(i);
                }
            }

            void addEdge(int i1, int i2) {
                Node n1 = nodes[i1];
                Node n2 = nodes[i2];
                if (!n1.adj.contains(n2)) {
                    n1.adj.add(n2);
                }
                if (!n2.adj.contains(n1)) {
                    n2.adj.add(n1);
                }
//                System.out.println("edge 추가: " + i1 + ", "+ i2);
            }

            List<Integer> dfs(int index) {
                Node root = nodes[index];
                Stack<Node> stack = new Stack<>();
                stack.push(root);
                root.marked = true;
                List<Integer> result = new ArrayList<>();
                while (!stack.isEmpty()) {
                    Node node = stack.pop();
                    Collections.sort(node.adj);
                    for (Node n : node.adj) {
                        if (!n.marked) {
                            n.marked = true;
                            stack.push(n);
                        }
                    }
                    result.add(node.data);
                }
                return result;
            }

            void dfsRecursive(Node node, List<Integer> result) {
                node.marked = true;
                result.add(node.data);

                Collections.sort(node.adj);
                for (Node neighbor : node.adj) {
                    if (!neighbor.marked) {
                        dfsRecursive(neighbor, result);
                    }
                }
            }

            List<Integer> bfs(int index) {
                Node root = nodes[index];
                ArrayList<Integer> bfsResult = new ArrayList<>();
                Queue<Node> queue = new LinkedList<>();
                queue.offer(root);
                root.marked = true;

                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    bfsResult.add(node.data);

                    Collections.sort(node.adj);
                    for (Node n : node.adj) {
                        if (!n.marked) {
                            n.marked = true;
                            queue.offer(n);
                        }
                    }
                }
                return bfsResult;
            }
        }



        // 1: size 2: iteration 3: startIdx
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int iter = Integer.parseInt(st.nextToken());
        int startIdx = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(size);
        for (int i = 0; i < iter; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st1.nextToken());
            int i2 = Integer.parseInt(st1.nextToken());
            graph.addEdge(i1, i2);
        }


//        List<Integer> dfsResult = graph.dfs(startIdx);
        ArrayList<Integer> dfsResult = new ArrayList<>();
        graph.dfsRecursive(graph.nodes[startIdx], dfsResult);

        for (int i = 1; i <= size; i++) {
            graph.nodes[i].marked = false;
        }

        List<Integer> bfsResult = graph.bfs(startIdx);
        String dfsResult1 = dfsResult.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        String bfsResult1 = bfsResult.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(dfsResult1);
        System.out.println(bfsResult1);
    }
}
