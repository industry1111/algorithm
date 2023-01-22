package programmers.levelOne;

import java.util.Arrays;

public class longToIntArray {
    public static void main(String[] args) {
        Long n = 12345L;

        String str = String.valueOf(n);
        int len = str.length();
        int[] arr = new int[len];

        for( int i=0; i<len; i++) {
            char ch = str.charAt(len - 1 - i);
            arr[i] = ch-'0';
        }
        System.out.println(Arrays.toString(arr));


    }
}
