package programmers.levelOne;

import java.util.Arrays;

/*
* 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수,
* 그다음 최소공배수를 넣어 반환하면 됩니다. 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

제한 사항
* */
public class 최대공약수최소공배수 {
    public static void main(String[] args) {
        int n = 12;
        int m = 18;

        System.out.println(Arrays.toString(solution(n,m)));
    }

    public static int[] solution (int n , int m) {

        int len = n < m ? n : m;

        int[] arr = new int[2]; // {gcd,lcm}
        arr[0] = 1;
        for ( int i=2; i<=len; i++) {
            if ( n%i == 0 && m%i ==0) {
                arr[0]=i;
            }
        }
        arr[1] = (n * m) / arr[0];


        return arr;
    }

}
