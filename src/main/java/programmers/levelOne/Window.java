package programmers.levelOne;

import java.util.Arrays;

public class Window {
    public static void main ( String[] args ) {

        String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};

        System.out.println(Arrays.toString(solution(wallpaper)));
    }

    private static int[] solution(String[] wallpaper) {
        int[] answer = {51,51,-1,-1};

        //윈도우 화면 크기 x * y
        int x = wallpaper.length-1;
        int y = wallpaper[0].length()-1;

        char[] dirIndex = {};

        for ( int i=0; i< wallpaper.length; i++ ) {

            dirIndex = wallpaper[i].toCharArray();

            for ( int j=0; j<dirIndex.length; j++ ) {

                if ( dirIndex[j] == '#' ) {
                    if ( answer[0] > i ) answer[0] = i;
                    if ( answer[1] > j ) answer[1] = j;
                    if ( answer[2] < i ) answer[2] = i;
                    if ( answer[3] < j ) answer[3] = j;
                }
            }
        }
        answer[2]++;
        answer[3]++;
        return answer;
    }
}
