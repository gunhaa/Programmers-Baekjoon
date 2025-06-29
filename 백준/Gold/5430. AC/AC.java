import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        Ac ac;
        for (int i = 0; i < testCase; i++) {
            String operation = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String result = line.substring(1, line.length() - 1);
            String[] tempArr = result.split(",");
            ac = new Ac(tempArr);

            for(char c : operation.toCharArray()){
                if(c == 'R') {
                    //logic
                    ac.reverse();
                    continue;
                }
                if( c== 'D') {
                    //logic
                    boolean isDeleted = ac.delete();
                    if(!isDeleted) {
                        break;
                    }
                }
            }
            ac.print();
            bw.flush();
        }
        bw.close();
    }

    static class Ac {
        int len;
        LinkedList<Integer> list;
        boolean isReversed;

        Ac(String[] tempArr) {
            LinkedList<Integer> list = new LinkedList<>();
            for(String s: tempArr) {
                if(s.isEmpty()) {
                    continue;
                }
                list.add(Integer.valueOf(s));
            }
            this.list = list;
            this.len = list.size();
            this.isReversed = false;
        }

        void reverse() {
            if(this.isReversed) {
                this.isReversed = false;
            } else {
                this.isReversed = true;
            }
        }

        boolean delete() {
            if(this.len == 0) {
                this.len = -1;
                return false;
            }

            if(this.isReversed) {
                this.list.pollLast();
            } else {
                this.list.pollFirst();
            }
            this.len -= 1;
            return true;
        }

        void print() throws IOException {
            if(len == -1) {
                bw.write("error\n");
                return;
            }
            printList();
        }

        private void printList() throws IOException {
            bw.write("[");

            int iter = this.list.size();

            if(this.isReversed) {
                for(int i=0; i<iter; i++) {
                    if(i == (iter-1)) {
                        bw.write(String.valueOf(this.list.pollLast()));
                        continue;
                    }
                    bw.write(String.valueOf(this.list.pollLast()+","));
                }
            } else {
                for(int i=0; i<iter; i++) {
                    if(i == (iter-1)) {
                        bw.write(String.valueOf(this.list.pollFirst()));
                        continue;
                    }
                    bw.write(String.valueOf(this.list.pollFirst()+","));
                }
            }
            bw.write("]\n");
        }
    }
}
