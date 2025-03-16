import java.util.*;

class Solution {
    public int solution(int[][] maps) {

        final int[] dx = {0, 0, -1, 1};
        final int[] dy = {-1, 1, 0, 0};

        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});

        while(!queue.isEmpty()){

            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if(x == n-1 && y == m-1){
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if(cx >= 0 && cy >=0 && cx < n && cy < m && maps[cx][cy] ==1 && !visited[cx][cy]){
                    visited[cx][cy] = true;
                    queue.add(new int[]{cx, cy, distance+1});
                }
            }

        }

        return -1;
    }
}