package programmers.leveltwo;

import java.util.*;

public class TangerinePicker {

    public static void main(String[] args) {

        int k = 4;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3,1,1,20};

        System.out.println(solution(k, tangerine));
    }

    public static int solution(int k,int[] tangerine) {

        Map<Integer, Integer> tangerineMap = new HashMap<>();

        for (int size : tangerine) {
            tangerineMap.put(size,tangerineMap.getOrDefault(size,0)+1);
        }

        List<Integer> tangerineList = new ArrayList<>();

        for (int size : tangerineMap.keySet()) {
            tangerineList.add(tangerineMap.get(size));
        }

        Collections.sort(tangerineList,Collections.reverseOrder());

        int cnt = 0;

        for (int count : tangerineList) {
            k -= count;
            cnt++;
            if (k <= 0) {
                break;
            }
        }
        return cnt;
    }

}
