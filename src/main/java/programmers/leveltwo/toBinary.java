package programmers.leveltwo;

import java.util.Arrays;

class toBinary {
    public int[] solution(String s) {

        char[] arr = s.toCharArray();
        int[] result = {0,0};
        int cnt;
        while(arr.length != 1) {
            cnt = 0;
            result[0]++;
            for(char ch : arr) {
                if (ch=='0'){
                    cnt++;
                }
            }
            arr = Integer.toBinaryString(arr.length-cnt).toCharArray();
            result[1] += cnt;
        }

        return result;
    }
}