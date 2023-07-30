package javaBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*P.115
* 행복 왕국의 왕실 정원은 체스판과 같은 8 * 8 좌표평면이다. 왕실 정원의 특정한 한칸에 나이트가 서 있다.
* 나이트는매우 충성스러운 신하로서 매일 무술을 연마한다.
* 나이트는 말을 타고 있기 때문에 이동을 할 때는 1차 형태로만 이동할 수 있으며 정원 밖으로는 나갈 수 없다.
* 나이트는 특정한 위치에서 다음과 같은 2가지 경우로 이동할 수 있다.
* 1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동
* 2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동
*
* 이처럼 8 * 8 좌표 명편상에서 나이트의 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 작성하시오.
* 행의 위치는 1~8 열의 위치는 a~h로 표현한다.
* 예) 나이트가 a1에 있을 때 정원 밖으로 나갈 수 없기 떄문에 이동할 수 있는 경우의 수는 2가지이다.
*   1.오른쪽으로 두 칸 이동 후 아래로 한칸 이동하기 c2
*   2.아래로 두 칸 이동 후 오른쪽으로 한 칸 이동하기 b3
*
* 입력    출력
* a1      2
* */
public class royalNight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = st.nextToken();
        char[] chars = input.toCharArray();

        int col = chars[1]-48;
        int row = chars[0]-96;
        int cnt = 0;

        System.out.println("col : " + col + " row : " + row);
        int[][] steps = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};

        for (int[] step :
                steps) {
            if ( 1<= row+step[0] && row+step[0] <=  8
                && 1 <= col+step[1] && col+step[1] <= 8)
                cnt++;
        }

        System.out.println(cnt);

    }
}
