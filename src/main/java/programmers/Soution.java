package programmers;

import java.util.Arrays;
import java.util.Stack;

public class Soution {
    public static void main(String[] args){
        int[] answer = {70, 50, 80, 50};
        int limit = 100;
        int totalWeight = 0;
        int cnt = 1;

        Arrays.sort(answer);

        Stack<Integer> weights = new Stack<>();
        for (int i = 0; i < answer.length; i++) {
            weights.push(answer[i]);
        }

        while (!weights.isEmpty()) {
            if (limit >= totalWeight + weights.peek()) {

                totalWeight += weights.pop();
            } else {
                cnt++;
                totalWeight = 0;
            }
        }
    }

}
