package programmers.leveltwo;

import java.util.Arrays;

class stack {
    boolean solution(String s) {
        boolean answer = true;

        char[] arr = s.toCharArray();
        int cnt = 0;
        for (int i=0; i<arr.length; i++){

            if(arr[i] == '(') {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt < 0) answer = false;
            //answer를 false로 하는것보단 break로 for문을 나가는게...
        }

        if (cnt != 0) answer = false;

        return answer;
    }
    //stack을 사용해서 풀어보기!!
}