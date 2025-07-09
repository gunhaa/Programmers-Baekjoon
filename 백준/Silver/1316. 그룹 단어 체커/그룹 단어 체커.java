
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        final int iter = Integer.parseInt(br.readLine());
        for (int i = 0; i < iter; i++) {
            String line = br.readLine();
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if(j == 0) {
                    if(line.length() == 1) {
                        result++;
                        break;
                    }
                    set.add(c);
                    continue;
                }

                if(line.charAt(j-1) == c) {
                    if(j == line.length()-1) {
                         result++;
                    }
                    continue;
                }else {
                    if(set.contains(c)) {
                        break;
                    }

                    if(j == line.length()-1) {
                        result++;
                    }
                    set.add(c);
                }
            }
        }

        System.out.println(result);
    }
}
