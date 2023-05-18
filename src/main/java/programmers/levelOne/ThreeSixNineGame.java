package programmers.levelOne;

import java.util.Scanner;

public class ThreeSixNineGame {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        String str = "";

        for(int test_case = 1; test_case <=T; test_case++)
        {
            str = checkNum(test_case);
            System.out.print(str + " ");
        }

    }

    private static String checkNum(int n) {
        String result = "";

        String str = String.valueOf(n);

        for (char ch : str.toCharArray()) {
            if (ch == '3' || ch == '6' || ch == '9') {
                result += "-";
            }
        }

        if (result == "") result = str;

        return result;
    }
}
