package programmers.leveltwo.숫자변환하기;

public class convertNumber {

    static int X;
    static int N;
    static int result;
    public static void main(String[] args) {

        System.out.println(solution(10,40,5));
    }

    static int solution(int x, int y, int n) {

        result = Integer.MAX_VALUE;
        X = x;
        N = n;

        dfs(y,1);
        return result != Integer.MAX_VALUE ? result : -1;
    }

    static void dfs (int y, int count) {

        if (count >= result) {
            return;
        }

        if (X >= y) {
            if (X == y) {
                if (result > count) result = count;
            }
            return;
        } else {
            count++;
        }

        dfs(y%(X*3), count);
        dfs(y%(X*2), count);
        dfs(y-N, count);
    }
}
