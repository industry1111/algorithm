package programmers.leveltwo.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockPrice {
    public static void main(String[] args) {

        int[] prices = {1,2,3,0,3};

//        System.out.println(Arrays.toString(solution(prices)));
        System.out.println(Arrays.toString(solution2(prices)));
    }

    //이중 for문으로 하나씩 비교
    //시간 복잡도 0(N^2)
    private static int[] solution(int[] prices) {

        int l = prices.length;
        int[] answer = new int[l];
        int cnt;

        for ( int i=0; i<l; i++ ) {
            cnt = 0;
            for ( int j=i+1; j<l; j++ ) {
//                if ( prices[i] <= prices[j] ) {
//                    cnt++;
//                } else {
//                    answer[i] = ++cnt;
//                    break;
//                }
                cnt++;
                if ( prices[i] > prices[j] ) break;
            }
            answer[i] = cnt;
        }

        return answer;
    }


    //stack 시간 복잡도 O(N)
    private static int[] solution2(int[] prices) {

        Stack<Integer> beginIdxs = new Stack<>();
        int i=0; //주식장 시간
        int[] terms = new int[prices.length];

        beginIdxs.push(i);
        for (i=1; i<prices.length; i++) {
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) { //하락장일 때만 전방 탐색
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i); //상승장일 경우 시간 그대로 푸쉬
        }

        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = i - beginIdx - 1;
        }

        return terms;

    }
}
