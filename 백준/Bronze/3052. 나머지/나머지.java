import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = 10;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<10; i++) {
            int line = Integer.valueOf(br.readLine());
            int mod = line % 42;
            set.add(mod);
        }
        System.out.println(set.size());
    }
}