
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for(int i=1; i <= count; i++){
            appendStar(i, count);
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static StringBuilder sb = new StringBuilder();

    private static void appendStar(int starCount, int lineCount){
        for(int i=0; i<lineCount-starCount; i++){
            sb.append(" ");
        }

        for(int i=0; i<starCount; i++){
            sb.append("*");
        }

        sb.append("\n");
    }
}
