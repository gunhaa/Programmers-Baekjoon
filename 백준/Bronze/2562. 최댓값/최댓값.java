import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        int max = -1;
        int location = 0;
        int offset = 0;
        while((line = br.readLine()) != null) {
            offset++;
            int item = Integer.parseInt(line);

            if(max < item){
                max = item;
                location = offset;
            }
        }

        bw.write(String.valueOf(max));
        bw.newLine();
        bw.write(String.valueOf(location));
        bw.flush();
    }
}
