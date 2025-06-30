import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int iter = Integer.parseInt(br.readLine());
            HashMap<String, Integer> clothes = new HashMap<>();
            for (int j = 0; j < iter; j++) {
                String line = br.readLine();
                String type = line.split(" ")[1];
                clothes.put(type, clothes.getOrDefault(type, 0)+1);
            }

            if(clothes.size() == 1) {
                System.out.println(iter);
                continue;
            }

            int temp = 1;
            for(Map.Entry<String, Integer> item : clothes.entrySet()) {
                Integer value = item.getValue();
                temp *= value+1;
            }
            System.out.println(temp-1);
        }
    }
}
