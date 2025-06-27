import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int idx = Integer.parseInt(br.readLine());
        System.out.println(line.charAt(idx-1));
    }
}