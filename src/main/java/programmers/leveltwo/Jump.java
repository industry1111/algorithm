package programmers.leveltwo;

public class Jump {

    public static void main(String[] args) {

        int n = 5;
        System.out.println(solution(n));
    }

    public static int solution(int n) {

        int[] arr = new int[n+1];

        arr[1] = 1;
        arr[2] = 2;

        if (n <= 2) {
            return arr[n];
        }

        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 1234567;
        }

        return arr[n];
    }
}
