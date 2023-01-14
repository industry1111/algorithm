package programmers.leveltwo;

import java.util.Arrays;

public class 두배열 {
    public static void main(String[] args) {
        int[] A = {1,4,2};
        int[] B = {5,4,4};

        solution(A,B);
    }

    public static void solution ( int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        int len = A.length;
        for (int i=0; i<len; i++) {
            sum+= A[i] * B[len-1-i];
        }

        System.out.println(sum);
    }
}
