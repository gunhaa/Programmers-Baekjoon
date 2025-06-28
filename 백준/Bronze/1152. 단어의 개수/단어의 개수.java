import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] result = line.split(" ");
        int sentenceNo = result.length;
        for(int i=0; i<result.length; i++) {
            int sentenceLen = result[i].length();
            if(sentenceLen == 0) {
                sentenceNo--;
            }
        }
        System.out.println(sentenceNo);
    }
}