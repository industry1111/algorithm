package programmers.levelOne;

import java.util.Arrays;

public class sum {
    public static void main(String[] args) {
        int n = 123;
        int answer = 0;
        String[] arr = String.valueOf(n).split("");
        for (String s : arr) {
            answer += Integer.parseInt(s);
        }
        System.out.println(answer);

    }
}
