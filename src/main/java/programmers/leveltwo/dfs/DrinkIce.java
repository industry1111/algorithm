package programmers.leveltwo.dfs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.StringTokenizer;

class DrinkIce {

    static int X,Y;
    static int[][] dd = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int size;

    //방문 확인용 2차원배열 선언
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트케이스 수
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        //입력을 담을 2차원 배열 선언
        char[][] map = new char[X][Y];

        //char 형식 맵 생성
        for (int i = 0; i < X; i++) {
            map[i] = br.readLine().toCharArray();
        }

        //방문 확인 맵 초기화
        visited = new boolean[X][Y];
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (!visited[i][j] && map[i][j] != '1') {
                    size = 0;
                    dfs(i,j,map);
                    results.add(size);
                }
            }
        }
        System.out.println("results = " + results);
//        for(int test_case = 1; test_case <=T; test_case++) {
//           String result = "";
//            System.out.println("#" + test_case + " " + result);
//        }
    }

    private static void dfs(int dx, int dy, char[][] map) {

        if( 0 > dx || dx >= X || 0 > dy || dy >= Y || visited[dx][dy] || map[dx][dy] == '1' ) {
            return;
        }

        visited[dx][dy] = true;
        size++;

        for (int i = 0; i < dd.length; i++) {

            int nextDx = dx + dd[i][0];
            int nextDy = dy + dd[i][1];

            dfs(nextDx, nextDy, map);
        }
    }

}
