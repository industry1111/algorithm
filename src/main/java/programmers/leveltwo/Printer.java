package programmers.leveltwo;

import java.util.*;

public class Printer {
    public static void main(String[] args) {
        int[] list = {1, 1, 9, 1, 1, 1};
        int location = 0;

        Queue<Map<Integer, Integer>> queue = new LinkedList<>();
        Map<Integer,Integer> map;

        for (int i=0; i<list.length; i++){

            //파일 순서 및 중요도
            map = new HashMap<>();
            map.put(i,list[i]);
            queue.add(map);
        }

        for (int i=0; i<list.length; i++) {
            int key = 0;
            for (Integer integer : queue.peek().keySet()) {
                key = integer;
            }

            if (i != 0 && queue.peek().get(key) < list[i]) {
                queue.add(queue.remove());
            }
            System.out.println(queue);
        }

        int result = 1;

        for (Integer integer : queue.remove().keySet()) {
            if(location == integer){
                break;
            }
            result++;
        }
        System.out.println(result);
    }
}
