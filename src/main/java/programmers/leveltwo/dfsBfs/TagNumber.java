package programmers.leveltwo.dfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

    public class TagNumber {

        static int N;

        static char[][] maps;
        static int[][] dd = {{1,0},{-1,0},{0,1},{0,-1}};

        static ArrayList<Integer> result;

        static int count;
        public static void main ( String[] args ) throws IOException {

            Scanner sc = new Scanner(System.in);

            N = Integer.parseInt(sc.nextLine());

            maps = new char[N][N];
            result = new ArrayList<>();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            for ( int i=0; i<N; i++ ) {
                String line = br.readLine();
                if (line == null) break;
                st = new StringTokenizer(line);
                if ( st.hasMoreTokens() )
                    maps[i] = st.nextToken().toCharArray();

            }

            solution(maps);
        }




        static void solution (char[][] maps) {

            for ( int i=0; i<N; i++ ) {
                for ( int j=0; j<N; j++ ) {
                    if ( maps[i][j] == '1' ) {
                        count = 1;
                        maps[i][j] = '0';
                        DFS(i,j);
                        result.add(count);
                    }
                }
            }
            result.sort(null);
            System.out.println(result.size());
            for (Integer integer : result) {
                System.out.println(integer);
            }
        }


        static void DFS ( int dx, int dy) {

            int next_dx,next_dy;


            for ( int[] xy : dd ) {
                next_dx = dx + xy[0];
                next_dy = dy + xy[1];

                if ( next_dx >= 0 && next_dx < N && next_dy >= 0 && next_dy < N && maps[next_dx][next_dy] == '1' ) {
                    count++;
                    maps[next_dx][next_dy] = '0';
                    DFS(next_dx,next_dy);
                }
            }


        }
}
