import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int temp = 1;

        loop:
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            switch (c) {
                case '(': {
                    stack.add(c);
                    temp *= 2;
                }
                break;
                case '[': {
                    stack.add(c);
                    temp *= 3;
                }
                break;
                case ')': {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        if (line.charAt(i - 1) == '(') {
                            result += temp;
                        }
                        stack.pop();
                        temp /= 2;
                    } else {
                        result = 0;
                        break loop;
                    }
                }
                break;
                case ']': {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        if (line.charAt(i - 1) == '[') {
                            result += temp;
                        }
                        stack.pop();
                        temp /= 3;
                    } else {
                        result = 0;
                        break loop;
                    }
                }
                break;
            }

        }

        if(!stack.isEmpty()) {
            System.out.println(0);
            return;
        }
        System.out.println(result);
    }
}
