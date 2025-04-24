
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int count = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] numChar = line.split("");

        for(int i=0; i<count; i++){
            sum += Integer.parseInt(numChar[i]);
        }


        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
