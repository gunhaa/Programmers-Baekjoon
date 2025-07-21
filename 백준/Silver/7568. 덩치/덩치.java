import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Person[] people = new Person[N];
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            Person p = new Person(weight, height);
            people[i] = p;
        }

        for (int i = 0; i < people.length; i++) {
            int bigger = 0;
            for (int j = 0; j < people.length; j++) {
                if(i != j) {
                    if(people[i].height < people[j].height && people[i].weight < people[j].weight) {
                        bigger++;
                    }
                }
            }
            answer[i] = bigger + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    static class Person {
        int weight;
        int height;

        Person(int w, int h) {
            this.weight = w;
            this.height = h;
        }
    }
}