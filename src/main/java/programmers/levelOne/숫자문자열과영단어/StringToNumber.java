package programmers.levelOne.숫자문자열과영단어;

import java.util.HashMap;
import java.util.Map;

public class StringToNumber {

    public static void main(String[] args) {
        String[] testCase = {"one4seveneight", "23four5six7", "2three45sixseven", "123"};
        int[] expected = {1478, 234567, 234567, 123};

        for (int i = 0; i < testCase.length; i++) {
            System.out.println(solution(testCase[i]) == expected[i]);
        }

        System.out.println("solution 2");

        for (int i = 0; i < testCase.length; i++) {
            System.out.println(solution2(testCase[i]) == expected[i]);
        }


    }

    static int solution(String s) {
        int result =0;

        String[][] convertArr = {{"zero","0"},{"one","1"},{"two","2"},{"three","3"},{"four","4"},{"five","5"},{"six","6"},{"seven","7"},{"eight","8"},{"nine","9"}};

        for (int i = 0; i < convertArr.length; i++) {
            s = s.replaceAll(convertArr[i][0],convertArr[i][1]);
        }
        result = Integer.parseInt(s);

        return result;
    }

    //보완점!
    //굳이 이차원 배열로 할 필요가 없다... 애초에 인덱스가 해당 숫자를 알려줌어..
    //String.valueOf vs Integer.toString() - https://github.com/industry1111/TIL/blob/main/Java/java_toString_valueOf.md
    static int solution2(String s) {
        int result =0;

        String[]convertArr = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for (int i = 0; i < convertArr.length; i++) {
            s = s.replaceAll(convertArr[i],Integer.toString(i));
        }
        result = Integer.parseInt(s);

        return result;
    }
}
