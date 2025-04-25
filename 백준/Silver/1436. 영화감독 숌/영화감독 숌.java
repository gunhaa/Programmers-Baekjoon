import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int target = Integer.parseInt(br.readLine());
        String searchTarget = "666";
        int start = 666;
        int answer;
        int answerCount = 0;

        for(;;){
            String s = String.valueOf(start);

            if(s.contains(searchTarget)){
                answerCount++;
            }

            if(answerCount == target){
                answer = start;
                break;
            }
            start++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
