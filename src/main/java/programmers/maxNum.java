package programmers;
import java.io.*;
import java.util.StringTokenizer;

/*
큰 수의 법칙
N개의 자연수를 M 번 더하여 가장 큰수를 구해라. ( 인덱스 하나당 연속해서 K번 까지 더할 수 있다. 같은 수라도 다른것으로 간주 )
첫 째 줄에는 N, M , K 세 자연수가 주어지며 각 자연수는 공백으로 구분한다.
둘째 줄에는 N개의 자연수가 주어진다. 각 자연수는 공백으로 구분 ( 자연수는 1 이상 10,000 이하의 수 )
입력으로 주어지는 K는 항상 M 보다 작거나 같다.
 */
public class maxNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

       String str = br.readLine();
       bw.write((str));
        bw.flush();
        bw.close();
    }
}
