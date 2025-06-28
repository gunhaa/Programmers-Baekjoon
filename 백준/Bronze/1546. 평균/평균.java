import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Double> grade = new ArrayList<>();
        double max = -1;
        for(int i=0; i<iter; i++) {
            double score = Double.parseDouble(st.nextToken());
            grade.add(score);
            max = Math.max(score, max);
        }
        ListIterator<Double> iter2 = grade.listIterator();
        double sum = 0;
        while(iter2.hasNext()) {
            double score = iter2.next();
            double trickScore = score/max*100;
            sum += trickScore;
        }
        System.out.println(sum/grade.size());
    }
}