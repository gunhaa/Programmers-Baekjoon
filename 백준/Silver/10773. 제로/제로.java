import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < iter; i++) {
            int money = Integer.parseInt(br.readLine());
            if (money != 0) {
                stack.add(money);
            } else {
                stack.pop();
            }
        }

        int result = 0;
        for(int m : stack) {
            result += m;
        }
        System.out.println(result);
    }
}
