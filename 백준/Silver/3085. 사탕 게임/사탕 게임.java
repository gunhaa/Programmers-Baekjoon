import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int max = Integer.MIN_VALUE;
        // 행을 탐색하며, 위 아래 swap을 모두 실행해 가능 값을 찾는다
        for (int i = 0; i < N; i++) {
            int tempCount = 0;
            int tempChar = '\u0000';
            for (int j = 0; j < N; j++) {
                if (board[i][j] == tempChar) {
                    tempCount++;
                } else {
                    tempChar = board[i][j];
                    tempCount = 1;
                }
                max = Math.max(max, tempCount);
            }
            // 위로 변경
            if (i > 0) {
                for (int k = 0; k < N; k++) {
                    // swap
                    tempCount = 0;
                    tempChar = '\u0000';
                    char memory = board[i][k];
                    board[i][k] = board[i - 1][k];
                    for (int j = 0; j < N; j++) {
                        if (board[i][j] == tempChar) {
                            tempCount++;
                        } else {
                            tempChar = board[i][j];
                            tempCount = 1;
                        }
                        max = Math.max(max, tempCount);
                    }
                    board[i][k] = memory;
                }
            }

            // 아래로 변경
            if (i + 1 < N) {
                for (int k = 0; k < N; k++) {
                    tempCount = 0;
                    tempChar = '\u0000';
                    char memory = board[i][k];
                    board[i][k] = board[i + 1][k];
                    for (int j = 0; j < N; j++) {
                        if (board[i][j] == tempChar) {
                            tempCount++;
                        } else {
                            tempChar = board[i][j];
                            tempCount = 1;
                        }
                        max = Math.max(max, tempCount);
                    }
                    board[i][k] = memory;
                }
            }
            // 좌
            for (int k = 0; k < N; k++) {
                tempCount = 0;
                tempChar = '\u0000';
                if (k > 0) {
                    char memory = board[i][k];
                    board[i][k] = board[i][k - 1];
                    board[i][k - 1] = memory;
                    for (int j = 0; j < N; j++) {
                        if (board[i][j] == tempChar) {
                            tempCount++;
                        } else {
                            tempChar = board[i][j];
                            tempCount = 1;
                        }
                        max = Math.max(max, tempCount);
                    }
                    board[i][k - 1] = board[i][k];
                    board[i][k] = memory;
                }
            }

            // 우
            for (int k = 0; k < N; k++) {
                tempCount = 0;
                tempChar = '\u0000';
                if (k + 1 < N) {
                    char memory = board[i][k];
                    board[i][k] = board[i][k + 1];
                    board[i][k+1] = memory;
                    for (int j = 0; j < N; j++) {
                        if (board[i][j] == tempChar) {
                            tempCount++;
                        } else {
                            tempChar = board[i][j];
                            tempCount = 1;
                        }
                        max = Math.max(max, tempCount);
                    }
                    board[i][k+1] = board[i][k];
                    board[i][k] = memory;
                }
            }
        }

        // 열탐색
        for (int i = 0; i < N; i++) {
            int tempCount = 0;
            int tempChar = '\u0000';
            for (int j = 0; j < N; j++) {
                if (board[j][i] == tempChar) {
                    tempCount++;
                } else {
                    tempChar = board[j][i];
                    tempCount = 1;
                }
                max = Math.max(max, tempCount);
            }
            // 위로 변경
            if (i > 0) {
                for (int k = 0; k < N; k++) {
                    // swap
                    tempCount = 0;
                    tempChar = '\u0000';
                    char memory = board[k][i];
                    board[k][i] = board[k][i - 1];
                    for (int j = 0; j < N; j++) {
                        if (board[j][i] == tempChar) {
                            tempCount++;
                        } else {
                            tempChar = board[j][i];
                            tempCount = 1;
                        }
                        max = Math.max(max, tempCount);
                    }
                    board[k][i] = memory;
                }
            }

            // 아래로 변경
            if (i + 1 < N) {
                for (int k = 0; k < N; k++) {
                    tempCount = 0;
                    tempChar = '\u0000';
                    char memory = board[k][i];
                    board[k][i] = board[k][i + 1];
                    for (int j = 0; j < N; j++) {
                        if (board[j][i] == tempChar) {
                            tempCount++;
                        } else {
                            tempChar = board[j][i];
                            tempCount = 1;
                        }
                        max = Math.max(max, tempCount);
                    }
                    board[k][i] = memory;
                }
            }

            // 상 변경
            for (int k = 0; k < N; k++) {
                tempCount = 0;
                tempChar = '\u0000';
                if (k > 0) {
                    char memory = board[k][i];
                    board[k][i] = board[k - 1][i];
                    board[k - 1][i] = memory;
                    for (int j = 0; j < N; j++) {
                        if (board[j][i] == tempChar) {
                            tempCount++;
                        } else {
                            tempChar = board[j][i];
                            tempCount = 1;
                        }
                        max = Math.max(max, tempCount);
                    }
                    board[k-1][i] = board[k][i];
                    board[k][i] = memory;
                }
            }

            // 하 변경
            for (int k = 0; k < N; k++) {
                tempCount = 0;
                tempChar = '\u0000';
                if (k + 1 < N) {
                    char memory = board[k][i];
                    board[k][i] = board[k + 1][i];
                    board[k+1][i] = memory;
                    for (int j = 0; j < N; j++) {
                        if (board[j][i] == tempChar) {
                            tempCount++;
                        } else {
                            tempChar = board[j][i];
                            tempCount = 1;
                        }
                        max = Math.max(max, tempCount);
                    }
                    board[k+1][i] = board[k][i];
                    board[k][i] = memory;
                }
            }
        }

        System.out.println(max);
    }
}
