import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] splitLine = line.split("");
            int sum = 0;
            int acc = 0;
            for (String item: splitLine) {
                if(item.equals("O")){
                    acc++;
                    sum += acc;
                } else {
                    acc = 0;
                }
            }

            bw.write(String.valueOf(sum));
            bw.newLine();
            bw.flush();
        }
    }

}
