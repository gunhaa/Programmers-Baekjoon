
import java.util.*;
import java.io.*;

public class Main {
    static final String NULL = "FRULA";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
            if(stack.size() >= bomb.length) {
                boolean isSerial = true;
                for (int j = 0; j < bomb.length; j++) {
                    if(bomb[bomb.length-j-1] != stack.get(stack.size()-j-1)) {
                        isSerial = false;
                        break;
                    }
                }
                
                if(isSerial) {
                    for(int j = 0; j< bomb.length; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if(stack.isEmpty()) {
            System.out.println(NULL);
            return;
        }

        for (int i = 0; i < stack.size(); i++) {
            result.append(stack.get(i));
        }
        System.out.println(result);
    }
}
