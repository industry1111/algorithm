package programmers.leveltwo;

import java.io.IOException;
import java.util.Arrays;

public class makeMin {
    public static void main(String[] args) throws IOException {

        int[] A = {1, 2, 3, 4};
        int[] B = {3, 4, 5, 6};
        System.out.println(solution(A,B));
    }

    public static int solution(int[] A, int[] B)
    {
        int answer = 0;
        int len = A.length-1;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0; i<=len; i++){
            answer += A[i]*B[len-i];
        }
        return answer;
    }

}
