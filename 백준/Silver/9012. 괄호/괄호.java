
import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        Stack<String> tempStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<count; i++){
            String[] lineStrings = br.readLine().split("");
            for (String s : lineStrings){
                stack.push(s);
            }

            int size = stack.size();
            for(int j =0; j< size; j++){
                String popItem = stack.pop();
                if(popItem.equals(")")){
                    tempStack.push(popItem);
                } else {
                    if(!tempStack.isEmpty()){
                        tempStack.pop();

                        if(!popItem.equals("(")){
                            result.append("NO");
                            break;
                        }

                    } else {
                        result.append("NO");
                        break;
                    }
                }
            }

            if(result.length() == 0 && stack.isEmpty() && tempStack.isEmpty()){
                result.append("YES");
            } else {
                if(result.length() == 0){
                    result.append("NO");
                }
            }


            bw.write(result.toString());
            bw.newLine();
            bw.flush();
            result.setLength(0);
            tempStack.clear();
            stack.clear();
        }
    }
}
