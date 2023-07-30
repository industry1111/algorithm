package programmers.levelOne.문자열내마음대로정렬하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StringSort {
    public static void main (String[] args) {
        String[] testCase = {"sun", "bed", "car"};
        int n = 1;

        System.out.println(Arrays.toString(solution(testCase,n)));
    }


    //마지막에 사전순으로 나열해야하기 때문에 처음에 사전순으로 정렬한뒤 해당인덱스(n)으로 정렬
    private static String[] solution(String[] strings, int n) {

        Arrays.sort(strings);

        insertion(strings,n);

        return strings;
    }

    private static void insertion (String[] strings, int n) {
        for (int end = 1; end < strings.length; end++) {
            for (int i = end; i > 0; i--) {
                if (strings[i - 1].charAt(n) > strings[i].charAt(n))
                    swap(strings, i - 1, i);
            }
        }
    }

    private static void swap(String[] arr, int a, int b) {
        String tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


    // 아예 생각하지도 못한 방법
    // n번째 문자를 문자열 맨앞에 추가한뒤 정렬 -> 추가한 문자 제외 후 배열에 입력
    public String[] solution2(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arr);
        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }
        return answer;
    }

}
