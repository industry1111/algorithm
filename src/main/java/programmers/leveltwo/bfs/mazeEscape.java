package programmers.leveltwo.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 동빈이는 N x M 크기의 직사각형 형태의 미로에 갇혀 있다.
 * 미로에는 여러 마리의 괴물이 있어 이를 피해 탈출해야 한다.
 * 동빈이의 위치는 (0,0)이고 미로의 출구는 (N,M)의 위치에 존재하며 한번에 한 칸씩 이동할 수 있다.
 * 이때 괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시되어 있다.
 * 미로는 반드시 탈출할 수 있는 형태로 제시된다.
 * 이때 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하라.
 * 칸을 셀 때는 시작 칸과 마지막 칸을 모두 포함해서 계산한다.
 * */

//효휼성 통과 X
public class mazeEscape {
    static boolean[][] visited;
    static int N;
    static int M;
    static int[][] dd = {{1, 0}, {-1, 0}, {0,1}, {0,-1}};

    public static void main(String[] args) {

        int[][] maps = {{1, 0, 1, 1, 1, 1}, {1, 0, 1, 0, 1, 0}, {1, 0, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 1, 1}};
        int N = 5;
        int M = 6;
        for (int[] map : maps) {
            System.out.println(Arrays.toString(map));
        }
        solution(N, M, maps);

    }

    private static void solution(int N, int M, int[][] maps) {
        mazeEscape.visited = new boolean[N][M];
        mazeEscape.N = N;
        mazeEscape.M = M;

        System.out.println(bfs(0, 0, maps));
    }

    private static int bfs(int dx, int dy, int[][] maps) {

        // 큐에 시작 위치 삽입
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        visited[dx][dy] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();
                int currentX = current[0];
                int currentY = current[1];
                int dist = current[2];


                if (currentX == N - 1 && currentY == M - 1) {
                    return  dist; // 탈출에 성공한 경우, 최소 칸의 개수를 반환
                }
                for (int[] arr : dd) {

                    int nextDx = currentX + arr[0];
                    int nextDy = currentY + arr[1];

                    if (nextDx < 0 || nextDy < 0 || nextDx >= N || nextDy >= M) {
                        continue;
                    } else if (!visited[nextDx][nextDy] && maps[nextDx][nextDy] == 1) {
                        visited[nextDx][nextDy] = true;
                        queue.offer(new int[]{nextDx, nextDy,dist+1});
                    }
                }
            }
        }
        return -1; // 탈출할 수 없는 경우 -1을 반환
    }
}
