import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> enc = new HashMap<>();
        HashMap<String, Integer> revEnc = new HashMap<>();
        for(int i=1; i < N+1; i++) {
            String pokemon = br.readLine();
            enc.put(i, pokemon);
            revEnc.put(pokemon, i);
        }

        for(int i=0; i<M; i++) {
            String line = br.readLine();
            try {
                int encNo = Integer.parseInt(line);
                System.out.println(enc.get(encNo));
            }catch(NumberFormatException e) {
                System.out.println(revEnc.get(line));
            }
        }
    }
}
