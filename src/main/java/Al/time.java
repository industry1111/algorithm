package Al;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이것이 코딩테스트다. 시각 p113
public class time {
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = null;
        while(st.hasMoreTokens()){
            str = st.nextToken();
        }

        int hour = Integer.parseInt(str);
        int cnt = 0;
        for(int i =0; i<=hour;i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++)
                    if (String.valueOf(i).contains("3") || String.valueOf(k).contains("3") || String.valueOf(j).contains("3")) {
                        cnt++;
                    }
            }
        }
        System.out.println(cnt);
    }
}
