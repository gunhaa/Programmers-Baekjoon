import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int stackTop = 1;

        for(int i=0; i<count; i++){
            int target = Integer.parseInt(br.readLine());

            while(stackTop <= target){
                stack.push(stackTop++);
                sb.append("+");
            }
            if(!stack.isEmpty()){
                Integer stackPop = stack.pop();
                if(stackPop == target){
                    sb.append("-");
                } else {
                    sb.setLength(0);
                    sb.append("NO");
                    break;
                }
            } else {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
        }

        String result;
        if(!sb.toString().equals("NO")){
            String[] strings = sb.toString().split("");
            result = Arrays.stream(strings).collect(Collectors.joining("\n"));
        } else {
            result = sb.toString();
        }

        bw.write(result);
        bw.flush();
    }
}
