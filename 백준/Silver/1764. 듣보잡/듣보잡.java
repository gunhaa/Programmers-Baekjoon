import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> duplicatedCheckMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int iter1 = Integer.parseInt(st.nextToken());
        int iter2 = Integer.parseInt(st.nextToken());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < (iter1+iter2); i++) {
            String line = br.readLine();
            duplicatedCheckMap.put(line, duplicatedCheckMap.getOrDefault(line, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : duplicatedCheckMap.entrySet()) {
            if(entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}
