import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        int sLen = sentence.length();
        List<String> list = new ArrayList<>();
        for (int i = 1; i < sLen; i++) {
            for (int j = i + 1; j < sLen; j++) {
                String one = new StringBuilder(sentence.substring(0, i)).reverse().toString();
                String two = new StringBuilder(sentence.substring(i, j)).reverse().toString();
                String three = new StringBuilder(sentence.substring(j, sLen)).reverse().toString();
                list.add(one+two+three);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
