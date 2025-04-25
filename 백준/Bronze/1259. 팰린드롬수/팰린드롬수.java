
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while(!(line = br.readLine()).equals("0")){
            String[] splitLine = line.split("");
            StringBuilder reversedLine = new StringBuilder();
            for(int i=0; i< splitLine.length; i++){
                reversedLine.append(splitLine[splitLine.length-i-1]);
            }

            if(reversedLine.toString().equals(line)){
                bw.write("yes");
                bw.newLine();
            } else {
                bw.write("no");
                bw.newLine();
            }
            bw.flush();
        }

    }
}
