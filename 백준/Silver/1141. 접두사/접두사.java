import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String firstLine = br.readLine();
        int count = Integer.parseInt(firstLine);

        List<String> dic = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        for(int i=0; i<count; i++){
            dic.add(br.readLine());
        }

        dic.sort(Comparator.comparing(String::length).reversed());
        answer.add(dic.get(0));
        for(int j=1; j<dic.size(); j++) {
            String item = dic.get(j);
            boolean isContain = false;
            answer.add(item);

            for(int i=0; i<answer.size()-1; i++){
                if(answer.get(i).startsWith(item)){
                    isContain = true;
                }
            }
            if(isContain){
                answer.remove(item);
            }
        }
        bw.write(String.valueOf(answer.size()));
        bw.newLine();
        bw.flush();
    }
}
