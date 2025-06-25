
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());

        class DualPriorityQueue {
            final Map<Integer, Integer> syncMap;
            final PriorityQueue<Integer> maxPriorityQueue;
            final PriorityQueue<Integer> minPriorityQueue;

            public DualPriorityQueue() {
                maxPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
                minPriorityQueue = new PriorityQueue<>();
                syncMap = new HashMap<>();
            }

            void parseOper(String operation, int argument) {
                switch (operation) {
                    case "I": {
                        addQueue(argument);
                    }
                    break;
                    case "D": {
                        if(argument == 1) {
                            deleteMax();
                        }

                        if(argument == -1) {
                            deleteMin();
                        }
                    }
                    break;
                }
            }

            private void deleteMax() {
                while(!this.maxPriorityQueue.isEmpty()) {
                    Integer max = this.maxPriorityQueue.peek();
                    Integer syncCount = this.syncMap.getOrDefault(max, 0);
                    if (syncCount == 0) {
                        this.maxPriorityQueue.poll();
                        this.syncMap.remove(max);
                        continue;
                    }
                    syncMap.put(max, syncCount - 1);

//                    if (syncCount == 1) {
//                        syncMap.remove(max);
//                    } else {
//                        syncMap.put(max, syncCount - 1);
//                    }
                    this.maxPriorityQueue.poll();
                    break;
                }
            }

            private void deleteMin() {
                while(!this.minPriorityQueue.isEmpty()) {
                    Integer min = this.minPriorityQueue.peek();
                    Integer syncCount = this.syncMap.getOrDefault(min, 0);
                    if (syncCount == 0) {
                        this.minPriorityQueue.poll();
                        this.syncMap.remove(min);
                        continue;
                    }

                    syncMap.put(min, syncCount - 1);
//
//                    if (syncCount == 1) {
//                        syncMap.remove(min);
//                    } else {
//                        syncMap.put(min, syncCount - 1);
//                    }
                    this.minPriorityQueue.poll();
                    break;
                }
            }

            private void addQueue(int argument){
                this.maxPriorityQueue.add(argument);
                this.minPriorityQueue.add(argument);
                this.syncMap.put(argument, this.syncMap.getOrDefault(argument, 0) + 1);
            }

            void display() {

                cleanUp();

//                System.out.println(this.syncMap);
//                System.out.println(this.maxPriorityQueue);
//                System.out.println(this.minPriorityQueue);


                if(this.minPriorityQueue.isEmpty() && this.maxPriorityQueue.isEmpty()) {
                    System.out.println("EMPTY");
                    this.syncMap.clear();
                    return;
                }
                Integer max = this.maxPriorityQueue.peek();
                Integer min = this.minPriorityQueue.peek();
                this.minPriorityQueue.clear();
                this.maxPriorityQueue.clear();
                this.syncMap.clear();
                System.out.println(max + " " + min);
            }

            private void cleanUp() {
                while (!this.maxPriorityQueue.isEmpty()) {
                    Integer max = this.maxPriorityQueue.peek();
                    if (this.syncMap.containsKey(max) && this.syncMap.get(max)>0) {
                        break;
                    }
                    this.syncMap.remove(max);
                    this.maxPriorityQueue.poll();
                }

                while (!this.minPriorityQueue.isEmpty()) {
                    Integer min = this.minPriorityQueue.peek();
                    if (this.syncMap.containsKey(min)&& this.syncMap.get(min)>0) {
                        break;
                    }
                    this.syncMap.remove(min);
                    this.minPriorityQueue.poll();
                }
            }
        }

        DualPriorityQueue dpq = new DualPriorityQueue();

        for (int i = 0; i < iter; i++) {
            int size = Integer.parseInt(br.readLine());
            for (int j = 0; j < size; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String operation = st.nextToken();
                int argument = Integer.parseInt(st.nextToken());
                dpq.parseOper(operation, argument);
            }
            // 최대값, 최소값, 혹은 EMPTY
            dpq.display();
        }
    }
}
