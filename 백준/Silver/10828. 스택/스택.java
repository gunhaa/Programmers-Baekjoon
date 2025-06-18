import java.io.*;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            String command = br.readLine();
            int operand = 0;
            if (command.startsWith("push")) {
                String[] commands = command.split(" ");
                command = commands[0];
                operand = Integer.parseInt(commands[1]);
            }

            switch (command) {
                case "push": {
                    stack.push(operand);
                    break;
                }
                case "pop": {
                    try {
                        Integer pop = stack.pop();
                        System.out.println(pop);
                    }catch (EmptyStackException e) {
                        System.out.println(-1);
                    }
                    break;
                }
                case "size": {
                    int size = stack.size();
                    System.out.println(size);
                    break;
                }
                case "empty": {
                    boolean isEmpty = stack.isEmpty();
                    System.out.println(isEmpty ? 1 : 0);
                    break;
                }
                case "top": {
                    try {
                        Integer peek = stack.peek();
                        System.out.println(peek);
                    } catch (EmptyStackException e) {
                        System.out.println(-1);
                    }
                    break;
                }
            }

        }
    }
}
