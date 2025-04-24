import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<count; i++){
            int item = Integer.parseInt(st.nextToken());
            boolean isPrimitive = isPrimitive(item);

            if(isPrimitive){
                result++;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static boolean isPrimitive(int item){
        if(item == 1){
            return false;
        }

        for (int j = 2; j <= Math.sqrt(item); j++) {
            if(item%j == 0){
                return false;
            }
        }
        return true;
    }
}
