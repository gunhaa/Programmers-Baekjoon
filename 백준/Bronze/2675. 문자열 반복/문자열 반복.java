import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());
        for (int i = 0; i < iter; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int iter2 = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();
            String target = st.nextToken();
            for (char c : target.toCharArray()) {
                for (int j = 0; j < iter2; j++) {
                    sb.append(c);
                }
            }
            System.out.println(sb);
        }

    }
}
