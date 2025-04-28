import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        board = new String[x][y];

        String[] lines = new String[x];

        for(int i=0; i<x; i++){
            lines[i] = br.readLine();
        }

        for(int i=0; i < x; i++){
            for(int j=0; j < y; j++){
                board[i][j] = String.valueOf(lines[i].charAt(j));
            }
        }

        map.put("B", "W");
        map.put("W", "B");

        int xStart = 0;
        int xFinish = x+1-8;
        int yStart = 0;
        int yFinish = y+1-8;
        int min = 0x7fffffff;

        for (int i = xStart; i <xFinish; i++) {
            for (int j = yStart; j < yFinish; j++) {
                int searchB = validateBoard(i, j, "B");
                int searchW = validateBoard(i, j, "W");
                min = Math.min(searchW, Math.min(min, searchB));

            }
        }
        System.out.println(min);
    }

    private static HashMap<String, String> map = new HashMap<>();
    private static String[][] board;

    private static int validateBoard(int xStart, int yStart, String startStr){
        int count = 0;
        String correct = map.get(startStr);
        for(int i = xStart; i<xStart+8; i++){
            for(int j = yStart; j<yStart+8; j++){
                if(!correct.equals(board[i][j])){
                    count++;
                }
                correct = map.get(correct);
            }
            correct = map.get(correct);
        }
        return count;
    }
}
