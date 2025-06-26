
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());

        int[] memory = new int[12];

        memory[1] = 1;
        memory[2] = 2;
        memory[3] = 4;

        for (int i = 4; i < memory.length; i++) {
            memory[i] = memory[i-3] + memory[i-2] + memory[i-1];
        }

        for (int i = 0; i < iter; i++) {
            int line = Integer.parseInt(br.readLine());
            System.out.println(memory[line]);
        }
    }
}
