package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트케이스 수
        int T = Integer.parseInt(br.readLine());


        for(int test_case = 1; test_case <=T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            //입력되는 문자열은 모두 소문자로 입력
            String S = st.nextToken();
            String Z = st.nextToken();

//            boolean result = getPattern(S).equals(getPattern(Z));
            System.out.println(getPattern(S));
            System.out.println(getPattern(Z));

            String result = "no";
            if (getPattern(S).equals(getPattern(Z))) result = "yes";

            System.out.println("#" + test_case + " " + result);
        }
    }

    public static String getPattern(String text) {

        int n = text.length();

        // 문자열의 길이가 1 이하인 경우는 패턴으로 처리하지 않음
        if (n <= 1) {
            return text;
        }

        String pattern = "";
        for (int i = 1; i <= n / 2; i++) {
            String currentPattern = text.substring(0, i);
            if (text.matches("(" + currentPattern + ")+")) {
                pattern = currentPattern;
                break;
            }
        }

        return pattern.isEmpty() ? text : pattern;
    }

}
