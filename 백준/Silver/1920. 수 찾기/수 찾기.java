
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < count; i++) {
            hashSet.add(Integer.parseInt(st.nextToken()));
        }

        int count2 = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < count2; i++) {
            if(hashSet.contains(Integer.parseInt(st2.nextToken()))){
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }

    }
}
