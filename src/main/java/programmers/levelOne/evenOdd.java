package programmers.levelOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
* 프로그래머스 짝수와 홀수
* 정수 num이 짝수일 경우 "Even" 홀수일 경우 "Odd" 를 반환
*
* 입출력 예
* num return
* 2    Even
* 3    Odd
* */
public class evenOdd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String result = "";

        result = n % 2 == 0 ? "Even" : "Odd";

        System.out.println(result);
    }
}
