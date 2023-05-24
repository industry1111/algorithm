package programmers.leveltwo;

import java.util.Arrays;

public class NextBigNumber {

    private static int nextBinary(int n) {
        int cnt = 0;

        char[] nBinary = Integer.toBinaryString(n).toCharArray();
        System.out.println(Arrays.toString(nBinary));
        for (char ch : nBinary) {
            if (ch == '1') {
                cnt++;
            }
        }

        int nextNum = n;
        int nextNumCnt = 0;
        while (true) {
            nextNumCnt = 0;
            nextNum += 1;

            char[] nextNumBinary = Integer.toBinaryString(nextNum).toCharArray();

            for (char ch : nextNumBinary) {
                if (ch == '1') {
                    nextNumCnt++;
                }
            }
            if (cnt == nextNumCnt) {
                return nextNum;
            }
        }
    }
}
