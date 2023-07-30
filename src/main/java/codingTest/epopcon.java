package codingTest;

import java.util.Stack;
public class epopcon {
    public static void main(String[] args) {
        int[] testCase = {121, -121, 0, 11113, 11110, 10100, 131131};
        boolean[] result = {true, false, true, false, false, false, true};
        for (int i=0; i<testCase.length; i++) {
            System.out.println(solution1(testCase[i]));
// System.out.println("expected : "+ result[i] +", actual : " +solution1(testCase[i]));
        }
    }
    static boolean solution1(int number) {
//앞에 - 부호가 있을 경우 무조건 false
        if (number < 0 ) {
            return false;
        }
        char[] chars = String.valueOf(number).toCharArray();
        Stack<Integer> stack = new Stack<>();
//순서대로 스택에 푸쉬
        for (char ch : chars) {
            stack.push(Integer.valueOf(ch));
        }
//맨 마지막 값과 앞에 값 비교
        for (char ch : chars) {
            if (stack.pop() != Integer.valueOf(ch)) {
                return false;
            }
        }
        return true;
    }
}
