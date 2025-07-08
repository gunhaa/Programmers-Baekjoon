import java.util.*;
import java.io.*;
import java.math.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int factorial = Integer.parseInt(br.readLine());
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= factorial; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        int count = 0;
        char[] resultChar = result.toString().toCharArray();
        for (int i = resultChar.length - 1; i >= 0; i--) {
            if(resultChar[i] == '0') {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
