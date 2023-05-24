package programmers.leveltwo;

public class Carpet {
    private static int[] getCarpetXY(int n, int m) {
        int result[] = new int[2];
        //n : 갈색 격자 수 , m : 노란색 격자 수

        //두개의 격자 수를 더한 값이 카펫의 넓이
        int size = n + m;

        //노란색 격자로 만들 수 있는 사각형
        for (int i = 1; i < m; i++) {

            int div = m / i;
            int mod = m % i;
            //사각형이 만들어 지는 경우에만
            if (mod == 0) {
                if ((div + 2) * 2 + i * 2 == n) {
                    result[0] = Math.max(div,i) + 2;
                    result[1] = Math.min(div,i) + 2;
                }
            }
        }
        return result;
    }
}
