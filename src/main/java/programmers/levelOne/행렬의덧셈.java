package programmers.levelOne;

import java.util.Arrays;

public class 행렬의덧셈 {
    public static void main(String[] args) {
        int[][] a = {{1,3},{2,4}};
        int[][] b = {{2,3},{4,5}};

        solution(a,b);
    }

    public static void solution(int[][] a, int[][] b) {

        int len = a[0].length;
        int[][] result = new int[a.length][len];
        for ( int i=0; i< a.length; i++) {
            for ( int j=0; j<len; j++ ){
                result[i][j] = a[i][j] + b[i][j];
            }
            System.out.println(Arrays.toString(result[i]));
        }



    }
}
