
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st1.nextToken());
        int target = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<count; i++){
            int item = Integer.parseInt(st2.nextToken());
            if(target >= item) {
                list.add(item);
            }
        }
        Collections.sort(list);

        int result = 0;

        //N = 100^3 = 1000000 , 3중 루프 가능
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.size(); j++){
                for(int k=0; k<list.size(); k++){
                    if(i!=j && i!=k && j!=k){
                        int a = list.get(i);
                        int b = list.get(j);
                        int c = list.get(k);
                        int sum = a+b+c;
                        if(sum <= target && result < sum ) {
                            result = sum;
                        }
                    }
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();

    }
    
}
