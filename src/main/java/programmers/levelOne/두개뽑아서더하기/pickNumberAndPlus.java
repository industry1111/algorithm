package programmers.levelOne.두개뽑아서더하기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class pickNumberAndPlus {
    public static void main(String[] args) {
        int[] arr = {2,1,3,4,1};

        System.out.println(Arrays.toString(solution(arr)));
    }

    static int[] solution(int[] numbers) {

        Set<Integer> plusNumbers = new HashSet<>();
        for (int i=0; i<numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                plusNumbers.add(numbers[i]+numbers[j]);
                System.out.println(numbers[i]);
            }
        }

        int[] result = new int[plusNumbers.size()];
        int idx = 0;

        for (Integer plusNumber : plusNumbers) {
            result[idx++] = plusNumber;
        }

        Arrays.sort(result);

        return result;
    }
}
