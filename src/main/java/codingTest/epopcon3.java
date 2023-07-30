package codingTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class epopcon3 {
    public static void main(String[] args) {

        String[] testCases = {"()[]", "()[]{}", "(]", "]]", "()[][", "({[]})"};
        boolean[] expected = {true,true,false,false,false,true};

        for (int i=0; i<testCases.length; i++) {
            System.out.println(solution3(testCases[i]));
//            System.out.println("expected : " + expected[i] + ", actual : " + solution3(testCases[i]));
        }
    }


    static boolean solution3(String s) {

        boolean result = true;

        Map<Character,Character> brackets = new HashMap<>() {
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }
        };

        char[] chars = s.toCharArray();

        Stack<Character> charStack= new Stack<>();

        for (char ch : chars) {

            if (ch == '(' || ch == '{' || ch == '[') {
                charStack.push(ch);
            } else {

                //닫힌 괄호가 들어왔을 때 스택이 비어있으면 false 리턴
                if (charStack.isEmpty()) {
                  return  false;
                } else {
                    //괄호가 맞지 않을경우
                    char openBracket = charStack.pop();
                    if ( openBracket != brackets.get(ch)) {
                        return  false;
                    }
                }
            }
        }

        //스택에 괄호가 남아 있을 경우
        if (!charStack.isEmpty()) {
            result = false;
        }

        return result;
    }
}
