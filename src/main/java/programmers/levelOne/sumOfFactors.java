package programmers.levelOne;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 약수의 합
* */
public class sumOfFactors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sum = 0;
        //for (int i=1; i<=n; i++){
        for (int i=1; i<=n/2; i++){
            if( n%i == 0){
                sum += i;
            }
        }
        //System.out.println(sum);
        System.out.println(sum+n);
    }
}
//약수이므로 주어진 수의 절반까지만 루프를 돌고 마지막에 자신을 더해줌...