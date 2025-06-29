import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int iter1 = Integer.parseInt(st1.nextToken());
        HashMap<String, String> map = new HashMap<>();
        for(int i=0; i<iter1; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            map.put(st2.nextToken(), st2.nextToken());
        }
        int iter2 = Integer.parseInt(st1.nextToken());
        for (int i = 0; i < iter2; i++) {
            String line = br.readLine();
            bw.write(map.get(line) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
