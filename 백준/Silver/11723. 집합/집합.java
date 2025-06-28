
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iter; i++) {
            String[] line = br.readLine().split(" ");
            String operation = line[0];
            int argument = 0;

            if(!operation.equals("all") && !operation.equals("empty")) {
                argument = Integer.parseInt(line[1]);
            }

            switch(operation) {
                case "add": {
                    set.add(argument);
                    break;
                }
                case "remove": {
                    set.remove(argument);
                    break;
                }
                case "check": {
                    if(set.contains(argument)) {
//                        System.out.println(1);
                        sb.append(1+"\n");
                        break;
                    }
//                    System.out.println(0);
                    sb.append(0+"\n");
                    break;
                }
                case "toggle": {
                    if(set.contains(argument)) {
                        set.remove(argument);
                        break;
                    }
                    set.add(argument);
                    break;
                }
                case "all": {
                    set.clear();
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                }
                case "empty": {
                    set.clear();
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}