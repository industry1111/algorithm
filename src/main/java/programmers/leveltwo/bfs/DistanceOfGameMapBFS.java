package programmers.leveltwo.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfGameMapBFS {

    static boolean[][] visited;
    static int N;
    static int M;
    static int[][] dd = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main (String[] args) {

        int[][] maps = {{1, 0, 1, 1, 1, 1}, {1, 0, 1, 0, 1, 0}, {1, 0, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 1, 1}};

        for (int[] map : maps) {
            System.out.println(Arrays.toString(map));
        }


        System.out.println((solution(maps)));
    }

    private static int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;;
        visited = new boolean[N][M];

        return bfs(0,0,maps);
    }

    private static int bfs(int dx, int dy, int[][] maps) {

        Queue<int[]> queue = new LinkedList<>();
        //초기 노드값
        queue.offer(new int[] {0,0,1});
        visited[dx][dy] = true;

        while (!queue.isEmpty()) {
            //최근 위치값
            int[] curr = queue.poll();
            int curX = curr[0];
            int curY = curr[1];
            int dist = curr[2];

            //도착지점 도착시 거리 리턴
            if (curX == N - 1 && curY == M - 1) {
                return dist;
            }
            for (int[] arr : dd) {

                int nextX = curX + arr[0];
                int nextY = curY + arr[1];
                System.out.println("nextX = " + nextX + ", nextY = " + nextY);
                //맵 범위를 벗어났을 경우
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                } else if (!visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY, dist + 1});
                }
            }
        }
        //도착지점 도달하지 못할 경우
        return -1;
    }
}
