import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String line;
        while (!(line = br.readLine()).equals(".")) {

            stack.clear();

            List<Character> list = line.chars()
                    .mapToObj(c -> (char) c)
                    .filter(c -> c == '[' || c == ']' || c == '(' || c == ')')
                    .collect(Collectors.toList());

            if (list.size() == 0) {
                sb.append("yes\n");
            }

            for (int i = 0; i < list.size(); i++) {
                Character c = list.get(i);
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else {
                    Character peek;

                    try {
                         peek = stack.peek();

                    } catch (EmptyStackException e) {
                        sb.append("no\n");
                        break;
                    }

                    if (peek == null) {
                        sb.append("no\n");
                        break;
                    }

                    if (c == ')') {

                        if (peek == '(') {
                            stack.pop();
                        } else {
                            sb.append("no\n");
                            break;
                        }

                    } else if (c == ']') {

                        if (peek == '[') {
                            stack.pop();
                        } else {
                            sb.append("no\n");
                            break;
                        }
                    }
                }

                if (i == list.size() - 1) {
                    if (stack.isEmpty()) {
                        sb.append("yes\n");
                    } else {
                        sb.append("no\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
