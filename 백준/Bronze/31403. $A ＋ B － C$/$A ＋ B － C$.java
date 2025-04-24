
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        String ab = a+b;

        int numA = Integer.parseInt(a);
        int numB = Integer.parseInt(b);
        int numC = Integer.parseInt(c);
        int numAB = Integer.parseInt(ab);
        bw.write(String.valueOf(numA+numB-numC));
        bw.newLine();
        bw.write(String.valueOf(numAB-numC));
        bw.flush();
    }
}
