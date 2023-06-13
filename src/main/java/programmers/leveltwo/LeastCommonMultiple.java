package programmers.leveltwo;

public class LeastCommonMultiple {
    public static void main(String[] args) {
        int[] ints = {2, 4, 6, 11};

        System.out.println(solution(ints));

    }

    private static int solution(int[] ints) {

        int a = ints[0];
        int lcm = 0;
        for (int i = 1; i < ints.length; i++) {
            int b = ints[i];

            //최소 공배수
            if (a > b) {
                lcm = getGCD(a, b);
            } else {
                lcm = getGCD(b, a);
            }

            a = lcm;
        }

        return a;
    }

    private static int getGCD(int a, int b) {

        int mod = 0;
        int n = a * b;

        while (b != 0) {
            mod = a % b;
            a = b;
            b = mod;
        }

        return n/a;
    }
}
