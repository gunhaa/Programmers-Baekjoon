import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        class Member{
            String name;
            int age;
            int priority;

            Member(int age,  String name, int priority){
                this.name = name;
                this.age = age;
                this.priority = priority;
            }

            int getAge(){
                return this.age;
            }

            int getPriority(){
                return this.priority;
            }

            String getName(){
                return this.name;
            }

        }

        List<Member> list = new ArrayList<>();
        for(int i=0; i<count; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken(), i));
        }
        List<Member> sortedList = list.stream().sorted(Comparator.comparing(Member::getAge).thenComparing(Member::getPriority)).collect(Collectors.toList());

        for(Member m : sortedList){
            bw.write(String.valueOf(m.getAge()));
            bw.write(" ");
            bw.write(m.getName());
            bw.newLine();
        }
        bw.flush();

    }
}
