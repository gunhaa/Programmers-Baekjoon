
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        List<String> list = new ArrayList<>();
        list.add(br.readLine());
        list.add(br.readLine());
        list.add(br.readLine());
        int answer = 0;
        final int targetOffset = 3;

        for(int i=0; i < 3; i++){
            String item = list.get(i);
            boolean isNumber = isNumber(item);
            if(isNumber){
                int number = Integer.parseInt(item);
                int offset = targetOffset-i;
                answer = number+offset;
                break;
            }
        }
        String result = resultParser(answer);

        bw.write(result);
        bw.flush();
    }

    private static boolean isNumber(String s){

        try {
            Integer.parseInt(s);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    private static String resultParser(int answer){
        if(answer%3 == 0 && answer%5 ==0){
            return "FizzBuzz";
        } else if(answer%3 ==0){
            return "Fizz";
        } else if(answer%5 ==0){
            return "Buzz";
        } else {
            return String.valueOf(answer);
        }
    }
}
