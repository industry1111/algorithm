package programmers.leveltwo.숫자변환하기;

public class convertNumber {

    static int Y;
    static int N;
    static int result;
    static int[] dp = new int[100_000_000];

    public static void main(String[] args) {

        int x = 3;
        int y = 40;
        int n = 1;

        System.out.println(solution(x, y, n));
    }

    static int solution(int x, int y, int n) {

        result = Integer.MAX_VALUE;
        Y = y;
        N = n;

        dfs(x, 0);
        return result != Integer.MAX_VALUE ? result : -1;
    }

    static void dfs(int x, int count) {

        if (count >= result || (dp[x] != 0 && dp[x] <= count)) {
            return;
        }

        if (x >= Y) {
            if (x == Y) {
                System.out.println("ssssss x : " + x + " , count : " + count);
                result = count;
            }
            return;
        } else {
            dp[x] = count;
            count++;
        }
        System.out.println("x : " + x + " , count : " + count);

        dfs(x * 3, count);
        dfs(x * 2, count);
        dfs(x + N, count);
    }
}
