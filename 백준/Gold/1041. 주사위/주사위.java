import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final long diceS = 6;
        long diceN = Long.parseLong(br.readLine());
        long[] dice = new long[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dice.length; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;

        if (diceN == 1) {
            long edgeCaseMax = Long.MIN_VALUE;
            for (long i : dice) {
                edgeCaseMax = Math.max(edgeCaseMax, i);
                answer += i;
            }
            answer -= edgeCaseMax;
            System.out.println(answer);
            return;
        }

        // NxNxN 에서 밑면 제외시키면
        // 3면 개방 위쪽 구석블록
        // 2면 개방 사이블록
        // 1면 개방 가운데블록 전부


//        Arrays.sort(dice);

        // 최소값 idx - 0 , 1 , 2 순
        // 노출되는 면은 n^2 x 5임
        // 맨위 한개의 면은 특수하며, 4개의 면은 동일해서 x4하면됨

        // 블록단위의 loop를 도는게 가장 명확할듯
        // 3면 노출 갯수x 최소~3 - NxN의 위쪽 모서리 4개
        final long threeSidesBlock = 4;
        // 2면이 노출된 블록(N의 개수에 따른 동적 개수/ 갯수x최소~2 / 갯수 (N-2)*4 + (N-1)*4 )
        final long twoSidesBlock = (diceN - 2) * 4 + (diceN - 1) * 4;

        // 1면 노출된 블록(N의 갯수에 따른 동적 개수/ 갯수x최소값/ 갯수 (N-2)^2 + (N-2)(N-1)*4
        final long oneSidesBlock = (diceN - 2) * (diceN - 2) + (diceN - 2) * (diceN - 1) * 4;

        long oneSidesBlockMin = Long.MAX_VALUE;

        for (int i = 0; i < diceS; i++) {
            if (dice[i] < oneSidesBlockMin) {
                oneSidesBlockMin = dice[i];
            }
        }
        answer += oneSidesBlock * oneSidesBlockMin;

        long twoSidesBlockMin = Long.MAX_VALUE;
        for (int i = 0; i < diceS; i++) {
            for (int j = 0; j < diceS; j++) {
                if (i + j != 5 && i != j) {
                    twoSidesBlockMin = Math.min(twoSidesBlockMin, dice[i] + dice[j]);
                }
            }
        }
        answer += twoSidesBlock * twoSidesBlockMin;

        long threeSidesBlockMin = 0;
        for (int i = 0; i < 3; i++) {
            threeSidesBlockMin += Math.min(dice[i], dice[5 - i]);
        }
        answer += threeSidesBlock * threeSidesBlockMin;

        System.out.println(answer);
    }
}
