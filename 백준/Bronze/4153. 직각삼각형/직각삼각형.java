import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(;;){
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Double> list = new ArrayList<>();
            list.add(Double.parseDouble(st.nextToken()));
            list.add(Double.parseDouble(st.nextToken()));
            list.add(Double.parseDouble(st.nextToken()));
            Collections.sort(list);
            if(list.get(0)==0 && list.get(1)==0 && list.get(2)==0) {
                break;
            }

            if(isRight(list)){
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isRight(List<Double> list){
        return (Math.pow(list.get(0), 2) + Math.pow(list.get(1) , 2)) == Math.pow(list.get(2), 2);
    }
}
