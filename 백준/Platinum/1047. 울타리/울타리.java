import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Wood> woodList = new ArrayList<>();

        // stdin 나무 리스트 생성
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int woodLength = Integer.parseInt(st.nextToken());
            woodList.add(new Wood(x, y, woodLength));
        }

        List<Wood> insideWoodList = new ArrayList<>();
        List<Wood> outsideWoodList = new ArrayList<>();

        // 모든 사각형의 경우의 수를 구한다(N=40)
        for (int i = 0; i < woodList.size(); i++) {
            for (int j = i; j < woodList.size(); j++) {
                for (int k = 0; k < woodList.size(); k++) {
                    for (int l = k; l < woodList.size(); l++) {
                        insideWoodList.clear();
                        outsideWoodList.clear();

                        int x1 = woodList.get(i).x;
                        int x2 = woodList.get(j).x;
                        int y1 = woodList.get(k).y;
                        int y2 = woodList.get(l).y;

                        int minX = Math.min(x1,x2);
                        int maxX = Math.max(x1,x2);
                        int minY = Math.min(y1,y2);
                        int maxY = Math.max(y1,y2);

                        // 울타리의 필요 나무 갯수를 구한다
                        int needWoods = ((maxX - minX) + (maxY - minY)) * 2;

                        // 바깥 나무들의 위치를 구한다
                        for (int m = 0; m < woodList.size(); m++) {
                            Wood wood = woodList.get(m);
                            if (wood.x < minX || wood.x > maxX || wood.y < minY || wood.y > maxY) {
                                outsideWoodList.add(wood);
                            } else {
                                insideWoodList.add(wood);
                            }
                        }

                        // 외부의 나무는 반드시 다 소모한다
                        int count = 0;
                        int acc = 0;
                        for (Wood wood : outsideWoodList) {
                            count++;
                            acc += wood.length;
                        }
                        
                        if(acc >= needWoods){
                            // 최소값 갱신
                            min = Math.min(min, count);
                            continue;
                        }
                        // 내림차순 정렬
                        Collections.sort(insideWoodList);
                        // 안됬다면 추가 진행
                        for (int m = 0; m < insideWoodList.size(); m++) {
                            Wood wood = insideWoodList.get(m);
                            count++;
                            acc += wood.length;
                            if(acc >= needWoods){
                                // 최소값 갱신
                                min = Math.min(min, count);
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }

    static int min = Integer.MAX_VALUE;

    static class Wood implements Comparable<Wood>{
        int x;
        int y;
        int length;

        Wood(int x, int y, int getWoods) {
            this.x = x;
            this.y = y;
            this.length = getWoods;
        }

        @Override
        public int compareTo(Wood o) {
            return Integer.compare(o.length, this.length);
        }
    }
}
