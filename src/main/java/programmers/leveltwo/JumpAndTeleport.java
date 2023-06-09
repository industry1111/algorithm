package programmers.leveltwo;

public class JumpAndTeleport {
    public static void main(String[] args) {
        int n = 5000;
        System.out.println(solution(n));
    }
    public static int solution(int n) {

        int ans = 1;
        int number = n;

        while(number > 1) {
            if(number % 2 == 1) {
                ans++;
            }
            number /= 2;
        }
        return ans;
    }
}
