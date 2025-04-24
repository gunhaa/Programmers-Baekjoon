import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String target = br.readLine();
        int targetNum = Integer.parseInt(target);
        int length = target.length()-1;
        int maxDestructuring = length*9 + ( targetNum / (int) Math.pow(10, length));
        int result = 0;

        for(int i = targetNum-maxDestructuring; i <= targetNum ; i++){
            String[] stringArr = String.valueOf(i).split("");
            int temp = 0;
            for (String s : stringArr) {
                int digit = Integer.parseInt(s);
                temp += digit;
            }

            if(temp+i == targetNum){
                result = i;
                break;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();

    }
}
