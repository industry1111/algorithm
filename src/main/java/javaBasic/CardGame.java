package javaBasic;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/* P.96
* 1. 숫자가 쓰인 카드들이 N * M 형태로 놓여 있다. 이 때 N은 행의 개수, M 은 열의 개수를 의미
* 2. 먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택한다.
* 3. 그 다음 선택된 행에 포함된 카드들 중 가장 숫자가 낮은 카드를 뽑아야 한다.
*
* 각 행마다 가장 작은 수를 찾은 뒤에 그 수 중에서 가장 큰수를 찾는 게임
* 입력
* 첫째 줄에 숫자 카드들이 놓인 행의 개수와 열의 개수 공백을 기준으로 하여 각각 자연수로 주어진다 ( 1 < N,M < 100 )
* 3 3
* 3 1 2
* 4 1 4
* 2 2 2
*
* 출력
* 2
* 각 행의 가장 작은 숫자는 순서대로 1,1,2 이므로 출력은 2가 된다.
*
* */
public class CardGame {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] numArr = new int[N];

        int min = 0;
        int num = 0;
        for ( int idx=0; idx < N; idx++){
            StringTokenizer strToken = new StringTokenizer(br.readLine());
            min = Integer.parseInt(strToken.nextToken());
            while(strToken.hasMoreTokens()){
                num = Integer.parseInt(strToken.nextToken());
                if(num < min) {
                    min = num;
                }
            }
            numArr[idx] = min;
        }
        Arrays.sort(numArr);
        bw.write(numArr[N-1]+"");
        bw.flush();
        bw.close();
    }
}
