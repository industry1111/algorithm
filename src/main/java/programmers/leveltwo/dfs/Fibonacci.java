package programmers.leveltwo.dfs;

/*
* 문제 :
* 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
* */
public class Fibonacci {
    static long[] arr;
    public static void main(String[] args) {

        int n = 99;
        arr = new long[n+1];

        System.out.println(dfsFibonacci(n));
    }

    public static long dfsFibonacci(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        if (arr[n] != 0) {
            return arr[n];
        }

        //모듈러 연산
        arr[n] = (dfsFibonacci(n - 1) + dfsFibonacci(n - 2)) % 1234567;
        return arr[n];

    }
}
