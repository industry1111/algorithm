package softeer.금고털이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class safeBox {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int W = Integer.parseInt(st.nextToken());
       int n = Integer.parseInt(st.nextToken());

       int[] jewel = new int[10001];
       int result = 0;

       for (int i=0; i<n; i++) {
           String[] input = br.readLine().split(" ");
           int m = Integer.parseInt(input[0]);
           int p = Integer.parseInt(input[1]);
           jewel[p] += m;
       }

       int len = jewel.length;

       while (len > 0) {
           W -= jewel[--len] ;
           if (W <= 0) {
               result += jewel[len] * len + (W * len);
               break;
           } else {
               result += jewel[len] * len;

           }
       }
        System.out.println(result);
    }
}
