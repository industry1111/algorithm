package programmers.leveltwo.dfsBfs;

public class DistanceOfGameMap {

    static int[][]map;

    static int N;
    static int M;
    static boolean[][] visited;
    static int[] result;



    static int[][] dd = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main (String[] args) {

        int[][] maps = {{1}};


        System.out.println((solution(maps)));
    }

    private static int solution(int[][] maps) {

        map = maps;
        visited = new boolean[maps.length][maps[0].length];

        N = map.length;
        M = map[0].length;

        result = new int[1];

        visited[0][0] = true;
        dfs(0,0, 1);

        return result[0] == 0 ? -1 : result[0];
    }

    private static void dfs(int dx, int dy, int distance) {

        if ( dx == N-1 && dy == M-1 ) {
            if ( result[0] == 0 || result[0] > distance ) result[0] = distance;
            return;
        }

        for (int[] arr : dd) {

            int next_dx = dx+arr[0];
            int next_dy = dy+arr[1];

            //종료조건
            if (  next_dx < 0 ||  next_dx >= N || next_dy < 0 || next_dy >= M || map[next_dx][next_dy] == 0 || (dx == N-1 && dy == M-1)) {
                continue;
            }

            if ( !visited[next_dx][next_dy]) {
                visited[next_dx][next_dy] = true;
                dfs(next_dx, next_dy, distance+1);
                visited[next_dx][next_dy] = false;
            }
        }
    }
}
