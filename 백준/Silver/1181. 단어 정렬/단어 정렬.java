
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();

        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++){
            set.add(br.readLine());
        }
        List<String> answer = set.stream().sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder())).collect(Collectors.toList());

        for(String s : answer) {
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
    }

}
