import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int result = Integer.MAX_VALUE;
    static int maxChicken;
    static int index;
    static ArrayList<int[]> people = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static int[][] city;
    static ArrayList<int[]> selectedChicken = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        index = Integer.parseInt(st1.nextToken());
        maxChicken = Integer.parseInt(st1.nextToken());
        city = new int[index][index];


        for (int i = 0; i < index; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < index; j++) {
                city[i][j] = Integer.parseInt(st2.nextToken());
                if(city[i][j] == 1) {
                    people.add(new int[]{i, j});
                    continue;
                }
                if(city[i][j] == 2) {
                    chicken.add(new int[]{i,j});
                    continue;
                }
            }
        }
        back(0, 0);

        System.out.println(result);
    }

    static void back(int depth, int start) {
        if(depth == maxChicken) {
            //선택된 치킨집과의 거리 모두 구함 그리고 그 중 최소값 끼리 전부 더해서 Result에 넣음
            int sum = 0;
            for(int[] person : people) {
                int min = Integer.MAX_VALUE;
                for (int[] selectedChickenHouse : selectedChicken) {
                    int x = Math.abs(selectedChickenHouse[0]-person[0]);
                    int y = Math.abs(selectedChickenHouse[1]-person[1]);
                    int distance = x+y;
                    min = Math.min(distance, min);
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            selectedChicken.add(chicken.get(i));
            back(depth + 1, i + 1);
            selectedChicken.remove(chicken.get(i));
        }
    }
}
