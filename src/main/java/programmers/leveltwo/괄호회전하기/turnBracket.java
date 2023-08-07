package programmers.leveltwo.괄호회전하기;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class turnBracket {

    public static void main(String[] args) {
        String[] testCases = {"[](){}", "}]()[{", "(]", "]]", "()[][", "({[]})"};

        for (int i=0; i<testCases.length; i++) {
            System.out.println(solution(testCases[i]));
        }
    }

    private static int solution(String brackets) {

        int result = 0;

        char[] bracketArr = brackets.toCharArray();

        for (int i=0; i<bracketArr.length; i++) {

            if (i > 0) {
                leftShift(bracketArr);
            }

            if (checkBracket(bracketArr)) {
                result++;
            }

        }



        return result;
    }

    private static boolean checkBracket(char[] bracketArr) {

        boolean result = true;


        Map<Character,Character> bracketMap = new HashMap<>() {
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }
        };

        Stack<Character> bracketStack = new Stack<>();

        for (char bracket : bracketArr) {

            if (bracket == '(' || bracket == '{' || bracket == '[') {
                bracketStack.push(bracket);
            } else {

                if (bracketStack.isEmpty()) {
                    result = false;
                    break;
                }

                if (bracketMap.get(bracket) != bracketStack.pop()) {
                    result = false;
                    break;
                }

            }
        }

        if (!bracketStack.isEmpty()) {
            result = false;
        }

        return result;
    }

    private static char[] leftShift(char[] chars) {

        int len = chars.length;
        char tmp = chars[0];

        for (int i=0; i<len-1; i++) {
            chars[i] = chars[i+1];
        }

        chars[len-1] = tmp;

        return  chars;
    }


}
