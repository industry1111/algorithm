package programmers.leveltwo.dfs;

/*
n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
사용할 수 있는 숫자가 담긴 배열 numbers,타겟 넘버 target이 매개변수로
주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는
방법의 수를 return 하도록 solution 함수를 작성해주세요.
*/
public class targetNumber {

    static int[] numbers;
    static int target;
    static int result;
    public  static void main(String[] args) {

        int number[] = {1, 1, 1, 1, 1};

        int target = 3;
        solution(number,target);
    }

    private static void solution(int[] numbers, int target) {
        targetNumber.numbers = numbers;
        targetNumber.target = target;
        result = 0;

        dfs(0,0);
        System.out.println(result);
    }

    private static void dfs(int index, int sum) {
        //2. 탈출조건
        if (numbers.length == index) {
            if(sum == target) result++;
            return;
        }
        //1. 수행동작
        dfs(index+1,sum+numbers[index]);
        dfs(index+1,sum-numbers[index]);
    }
}