package programmers.leveltwo;

/*
* 예상 대진표
* 문제 설명
*  : 토너먼트 형식의 게임에서 특정 선수가 몇 번째 라운드에서
*   진출하는지 알아내려 합니다. 게임은 다음과 같은 규칙으로 진행됩니다.
*  - 1. N명이 참가하는 토너먼트에서 각 참가자는 1번부터 N번을 차례대로 배정받습니다.
* - 2. 그리고 1번↔2번, 3번↔4번, ... , N-1번↔N번의 참가자끼리 게임을 진행합니다.
* - 3. 각 게임에서 이긴 사람은 다음 라운드에 진출할 수 있습니다.
* - 4. 이때, 다음 라운드에 진출할 참가자의 번호는 다시 1번부터 N/2번을
*  차례대로 배정받습니다.
* - 5. 만약 1번↔2번 게임에서 2번이 승리했다면 다음 라운드에서 1번을
* 부여받고 3번↔4번 게임에서 3번이 승리했다면 다음 라운드에서 2번을
* 부여받게 됩니다.
* - 6. 게임은 최종 한 명이 남을 때까지 진행됩니다.
* - 7. 마지막 남은 참가자의 번호를 return 하도록 solution 함수를 완성해주세요.
* * */
public class ExpectedMatchups {
    public static void main(String[] args) {
        System.out.println(solution(8, 12, 9));
    }

    public static int solution(int n, int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        while (true) {

            int minEx = getExponent(min);
            int maxEx = getExponent(max);

            if(minEx == 1 && maxEx == 1) {
                return 1;
            }

            if (minEx == maxEx) {
                min %= Math.pow(2, maxEx-1);
                max %= Math.pow(2, maxEx-1);
                if (max == 0) {
                    max = (int) Math.pow(2, maxEx-1);
                }
            } else {
                return maxEx;
            }
        }
    }

    //지수 찾기
    public static int getExponent(int n) {

        int exponent = 1;
        double result= 0 ;

        while (result < n) {
            result = Math.pow(2, exponent++);
        }

        return exponent-1;
    }


}
