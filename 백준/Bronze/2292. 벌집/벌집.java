import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        int depthRoom = 0;
        int acc = 1;
        int depth = 1;
        while(target > acc) {
            depthRoom += 6;
            depth++;
            acc += depthRoom;
        }
        System.out.println(depth);
    }
}
