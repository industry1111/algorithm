package programmers.leveltwo.연속부분수열합의개수;

import java.util.*;
import java.util.stream.Stream;

public class ContinueCalculateSum {
    public static void main(String[] args){

        int [] elements = {1,4,3,2,5};
        System.out.println(solution(elements));
    }

    private static int solution(int[] elements) {

        Set<Integer> results = new HashSet<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int element : elements) {
            deque.add(element);
        }

        int len = elements.length;

        int tempN, cnt=0;
        for (int N = 1; N <= len; N++) {

            tempN = N;
            while (cnt != len) {

            }
        }
        System.out.println(results);

        return results.size();
    }
}
