import java.util.*;
import java.io.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static List<Integer> numbers = new ArrayList<>();
    static List<Character> operations = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        for (int i = 0; i < N; i++) {
            char cur = input.charAt(i);
            if (i % 2 == 0) {
                numbers.add(Character.getNumericValue(cur));
            } else {
                operations.add(cur);
            }
        }
        dfsR(numbers.get(0), 0);

        System.out.println(max);
    }

    static void dfsR(int result, int operatorIdx) {
        if (operatorIdx >= operations.size()) {
            max = Math.max(max, result);
            return;
        }

        // 괄호 X
        int result1 = calculate(result, numbers.get(operatorIdx + 1), operations.get(operatorIdx));
        dfsR(result1, operatorIdx + 1);

        // 괄호 O
        // 즉, 다음 operator가 존재한다면
        if (operatorIdx + 1 < operations.size()) {
            int result2 = calculate(numbers.get(operatorIdx + 1), numbers.get(operatorIdx + 2), operations.get(operatorIdx + 1));
            dfsR(calculate(result, result2, operations.get(operatorIdx)), operatorIdx + 2);
        }

    }

    static int calculate(int a, int b, char operator) {
        switch (operator) {
            case '+': {
                return a + b;
            }
            case '-': {
                return a - b;
            }
            case '*': {
                return a * b;
            }
        }
        return -1;
    }
}
