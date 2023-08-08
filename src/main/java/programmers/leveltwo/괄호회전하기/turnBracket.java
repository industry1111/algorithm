package programmers.leveltwo.괄호회전하기;

import java.util.Stack;

class turnBracket {

    private static final Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        String[] testCases = {"()[]", "()[]{}", "(]", "]]", "()[][", "({[]})"};
        boolean[] expected = {true,true,false,false,false,true};

        for (int i=0; i<testCases.length; i++) {
            System.out.println(solution(testCases[i]));
//            System.out.println("expected : " + expected[i] + ", actual : " + solution3(testCases[i]));
        }
    }

    public int solution(String s) {

        int answer = 0;

        StringBuilder stringBuilder = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {

            stringBuilder.append(stringBuilder.charAt(0));
            stringBuilder.deleteCharAt(0);

            if (correctBracket(stringBuilder.toString().toCharArray()))
                answer++;
        }
        return answer;
    }

    private  boolean correctBracket(char[] s) {
        for (char c : s) {
            if (!(check(c, '(', ')') && check(c, '[', ']') && check(c, '{', '}')))
                return false;
        }
        return stack.isEmpty();
    }

    private  boolean check(char c, char a, char b) {
        if (c == a)
            stack.push(a);
        else if (c == b)
            if (!stack.isEmpty() && stack.peek() == a) stack.pop(); else return false;
        return true;
    }



}
