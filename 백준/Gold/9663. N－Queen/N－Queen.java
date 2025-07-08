import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] board;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        int row = 0;
        back(row);

        System.out.println(count);
    }

    static void back(int row) {

        if (row == N) {
//            System.out.println(Arrays.toString(board));
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            board[row] = col;
            if (isQueen(row)) {
//                System.out.println(Arrays.toString(board));
                back(row + 1);
            }
        }
    }

    static boolean isQueen(int row) {
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i]) {
                return false;
                // 해당 코드의 원리는 피타고라스 원리의 직각 삼각형을 생각하면 쉬움
                // 대각선에 있는지 x의 좌표, y의 좌표끼리 연산(-)를 통해 구하는 조건문
            } else if (Math.abs(row - i) == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }
}
