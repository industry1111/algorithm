package codingTest;

public class epopcon5 {

    static int[] numbers;
    static int target;
    static int result;
    public  static void main(String[] args) {

        int[][] testCase = {{4,1,2,1},{1,1,1,1,1},{1,1}};
        int[] target = {4,3,1};

        for (int i=0; i<testCase.length; i++) {
            System.out.println(solution(testCase[i],target[i]));
        }
    }

    static int solution(int[] numbers, int target) {

        epopcon5.numbers = numbers;
        epopcon5.target = target;
        result = 0;

        dfs(0,0);
        return result;
    }

    static void dfs(int index, int sum) {
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
