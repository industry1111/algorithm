package softeer.바이러스;

import java.io.*;
public class virus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long K = Integer.parseInt(input[0]);
        long P = Integer.parseInt(input[1]);
        long N = Integer.parseInt(input[2]);
        for(int i=0; i<N; i++) {
            K *= P;
            K %= 1000000007;
        }
        System.out.println(K);
    }
}
