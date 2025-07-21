import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();
        int power = 0;
        int result = 0;
        for (char c : str) {
            double cur = (int) c - 96;
            result += (int) (cur * (int) Math.pow(31, power++));
        }
        System.out.println(result);
    }
}
