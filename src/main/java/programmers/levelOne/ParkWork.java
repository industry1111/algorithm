package programmers.levelOne;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParkWork {
    public static void main ( String[] args ) {

        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};
        System.out.println(Arrays.toString(solution(park,routes)));
        System.out.println(Arrays.toString(solution2(park,routes)));
    }

    private static int[] solution(String[] park, String[] routes) {

        int[] answer = new int[2];

        //공원 최대 X,Y 좌표
        int mapX = park.length-1;
        int mapY = park[0].length()-1;

        //시작 좌표
        int[] XY = getStartXY(park);
        int nowX = XY[0];
        int nowY = XY[1];

        //방향
        String direction = "";
        int distance = 0;

        //임시 좌표
        int tmpX,tmpY;

        boolean flag = true;
        //명령 수행
        for ( int k=0; k<routes.length; k++ ) {

            tmpX = nowX;
            tmpY = nowY;

            direction = routes[k].split(" ")[0];
            distance = Integer.parseInt(routes[k].split(" ")[1]);

            flag = true;
            while ( distance-- > 0) {

                switch (direction) {
                    case "N" : tmpX -= 1; break;
                    case "S" : tmpX += 1; break;
                    case "W" : tmpY -= 1; break;
                    case "E" : tmpY += 1; break;
                }

                if ( 0 > tmpY || tmpY > mapY  || 0 > tmpX || tmpX > mapX || park[tmpX].toCharArray()[tmpY] == 'X') {
                    flag = false;
                    break;
                }
            }

            if ( flag ) {
                nowX = tmpX;
                nowY = tmpY;
            }
        }
        answer[0] = nowX;
        answer[1] = nowY;
        return answer;
    }

    private static int[] getStartXY(String[] park) {

        int[] XY = new int[2];

        char[] chars = new char[park[0].length()];
        for ( int i=0; i<park.length; i++ ){
            chars = park[i].toCharArray();
            for ( int j=0; j<chars.length; j++ ) {
                if ( 'S' == chars[j] ) {
                    XY[0] = i;
                    XY[1] = j;
                    break;
                }
            }
        }
        return XY;
    }

    private static int[] solution2(String[] park, String[] routes) {

        int[] answer = new int[2];

        //공원 최대 X,Y 좌표
        int mapX = park.length-1;
        int mapY = park[0].length()-1;

        //시작 좌표
        int[] XY = getStartXY(park);
        int nowX = XY[0];
        int nowY = XY[1];

        //방향
        String direction = "";
        int distance = 0;

        //임시 좌표
        int tmpX,tmpY;

        boolean flag = true;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        Map<String,Integer> moveType = new HashMap<>();
        moveType.put("N",0);
        moveType.put("S",1);
        moveType.put("W",2);
        moveType.put("E",3);

        //명령 수행
        for ( int k=0; k<routes.length; k++ ) {

            tmpX = nowX;
            tmpY = nowY;

            direction = routes[k].split(" ")[0];
            distance = Integer.parseInt(routes[k].split(" ")[1]);

            flag = true;
            while ( distance-- > 0) {

                 tmpX += dx[moveType.get(direction)];
                 tmpY += dy[moveType.get(direction)];

                if ( 0 > tmpY || tmpY > mapY  || 0 > tmpX || tmpX > mapX || park[tmpX].toCharArray()[tmpY] == 'X') {
                    flag = false;
                    break;
                }
            }

            if ( flag ) {
                nowX = tmpX;
                nowY = tmpY;
            }
        }
        answer[0] = nowX;
        answer[1] = nowY;
        return answer;
    }
}
