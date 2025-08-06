import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        LinkedList<Truck> trucks = new LinkedList<>();
        int n = Integer.parseInt(st1.nextToken());
        int w = Integer.parseInt(st1.nextToken());
        int L = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int weight = Integer.parseInt(st2.nextToken());
            trucks.add(new Truck(weight));
        }

        EventQueue eventQueue = new EventQueue(w, L, trucks);

        while(!eventQueue.isEmpty()) {
            eventQueue.nextTick();
        }

        System.out.println(eventQueue.time+1);
    }

    static class EventQueue {
        // 다리 길이
        int bridgeLen;
        // 최대하중
        int L;
        // 남은 하중
        int remainL;
        int time;
        LinkedList<Truck> remainTrucks;
        LinkedList<Truck> movingTrucks;

        EventQueue(int w, int L, LinkedList<Truck> remainTrucks) {
            this.bridgeLen = w;
            this.L = L;
            this.remainL = L;
            this.remainTrucks = remainTrucks;
            this.movingTrucks = new LinkedList<>();
            this.time = 0;
        }

        void nextTick() {
            if(!remainTrucks.isEmpty()) {
                Truck nextTruck = remainTrucks.peek();
                if(remainL >= nextTruck.weight) {
                    this.remainL -= nextTruck.weight;
                    remainTrucks.poll();
                    movingTrucks.add(nextTruck);
                }
            }

            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < movingTrucks.size(); i++) {
                Truck cur = movingTrucks.get(i);
                cur.pos++;
                if(cur.pos >= bridgeLen) {
                    temp.add(i);
                    remainL += cur.weight;
                }
            }

            for (int t : temp) {
                movingTrucks.remove(t);
            }

            this.time++;
        }

        boolean isEmpty() {
            return remainTrucks.isEmpty() && movingTrucks.isEmpty();
        }
    }

    static class Truck {
        int weight;
        // 위치
        int pos;

        Truck(int w) {
            this.weight = w;
            this.pos = 0;
        }
    }
}
