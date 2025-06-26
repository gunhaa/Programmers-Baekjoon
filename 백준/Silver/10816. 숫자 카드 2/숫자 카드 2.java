import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> deck = new HashMap<>();
        int iter1 = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < iter1; i++) {
            int card = Integer.parseInt(st1.nextToken());
            deck.put(card, deck.getOrDefault(card, 0) + 1);
        }
        int iter2 = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < iter2; i++) {
            int target = Integer.parseInt(st2.nextToken());
            result.add(deck.getOrDefault(target, 0));
        }
        String answer = result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(answer);
    }
}
