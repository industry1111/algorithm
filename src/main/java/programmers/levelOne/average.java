package programmers.levelOne;

import java.util.Arrays;
import java.util.OptionalDouble;

public class average {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        double result = 0;
        OptionalDouble average = Arrays.stream(arr).average();
        result = average.orElseThrow();

        System.out.println(result);
    }
}
