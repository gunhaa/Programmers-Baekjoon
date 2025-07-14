import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int iter = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < iter; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        for (int i : list) {
            bw.write(i+"\n");
        }
        bw.flush();
    }
}
