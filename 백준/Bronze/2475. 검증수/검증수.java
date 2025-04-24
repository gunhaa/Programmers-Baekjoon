import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());
        double d = Double.parseDouble(st.nextToken());
        double e = Double.parseDouble(st.nextToken());
        double result = calculateVerifyNum(a, b, c, d, e);

        bw.write(String.valueOf((int) result));
        bw.flush();
    }

    private static double calculateVerifyNum (double a, double b, double c, double d, double e) {
        double pa = Math.pow(a, 2);
        double pb = Math.pow(b, 2);
        double pc = Math.pow(c, 2);
        double pd = Math.pow(d, 2);
        double pe = Math.pow(e, 2);
        double sum = pa+pb+pc+pd+pe;
        return sum % 10;
    }
}
