import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for(int i=0; i<count; i++){
            String line = br.readLine();
            int input = Integer.parseInt(line);

            fiboPercolateUp(input);

            bw.write(String.valueOf(cache[input].acc0));
            bw.write(" ");
            bw.write(String.valueOf(cache[input].acc1));
            bw.newLine();
            bw.flush();
        }
    }

    static Cache[] cache;

    static class Cache {
        int acc0;
        int acc1;

        Cache(int acc0, int acc1){
            this.acc0 = acc0;
            this.acc1 = acc1;
        }
    }

    static void fiboPercolateUp(int root){
        cache = new Cache[root+1];
        cache[0] = new Cache(1,0);
        if(root > 0){
            cache[1] = new Cache(0,1);
        }

        for(int i=2; i <= root; i++){
            int acc0 = cache[i-2].acc0 + cache[i-1].acc0;
            int acc1 = cache[i-2].acc1 + cache[i-1].acc1;

            cache[i] = new Cache(acc0, acc1);
        }
    }
}
