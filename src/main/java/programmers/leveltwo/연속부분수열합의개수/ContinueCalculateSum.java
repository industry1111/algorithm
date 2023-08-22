package programmers.leveltwo.연속부분수열합의개수;

import java.util.*;
import java.util.stream.Stream;

public class ContinueCalculateSum {
    public static void main(String[] args){

        int [] elements = {7,9,1,1,4};
        System.out.println(solution(elements));
    }

    private static int solution(int[] elements) {

        Set<Integer> results = new HashSet<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int element : elements) {
            deque.add(element);
            results.add(element);
        }

        int len = elements.length;


        for (int N = 1; N < len; N++) {

           deque.addLast(deque.pollFirst());

            for (int j = 0; j < len; j++) {
                int n = deque.pollFirst();
                elements[j] += n;
                deque.addLast(n);
                results.add(elements[j]);
            }
        }

        return results.size();

    }
}
