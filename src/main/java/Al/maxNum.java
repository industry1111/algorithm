package Al;
import java.io.*;
import java.util.Arrays;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer stArr = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] arr = new int[n];

        for ( int idx=0; idx < n; idx++) {
            arr[idx] = Integer.parseInt(stArr.nextToken());
        }
        bw.write("n : " + n + ", m : " + m + ", k : " + k + "\n" );
        bw.write(Arrays.toString(arr) + "\n");

        Arrays.sort(arr);

        int first  = arr[n-1]; // 가장 큰 수
        int second = arr[n-2]; // 두번째로 큰 수
        int cnt = ( m / (k+1) ) * k;
        cnt += m % (k+1);

        result = (first * cnt) + second * (m-cnt);

        bw.write(result+"");

        bw.flush();
        bw.close();
    }
}

