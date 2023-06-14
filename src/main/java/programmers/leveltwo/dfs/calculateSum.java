package programmers.leveltwo.dfs;

import java.util.Arrays;

public class calculateSum {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,3,3,2};
        int k = 6;
        System.out.println(Arrays.toString(solution2(arr,k)));

    }

    private static int[] solution2(int[] sequence, int k) {
        int[] result = new int[2];

        //sequence의 합
        int sum = 0;

        int startIndex = 0;
        int lastIndex = 0;

        int len = 1000001;

        for (int i = 0; i < sequence.length; i++) {

            lastIndex = i;

            sum += sequence[i];

            while (sum > k) {
                sum -= sequence[startIndex++];
            }

             if (k == sum && len > lastIndex - startIndex) {
                    result[0] = startIndex;
                    result[1] = lastIndex;
                    len = lastIndex - startIndex;
                    if(len == 0) break;
             }

        }
        return result;
    }


    //시간초과
    private static int[] solution(int[] sequence, int k) {

        int[] result = new int[2];
        int sum = 0;
        int len = 10000000;
        int idx = 0;
        for (int i = 0; i < sequence.length; i++) {

            sum = sequence[i];

            if (sum == k) {
                result[0] = i;
                result[1] = i;
                break;
            }


            for (int j = i + 1; j < sequence.length; j++) {

                sum += sequence[j];

                if (k >= sum && len > j - i)  {

                    if (k == sum) {
                        //시작인덱스
                        result[0] = i;
                        result[1] = j;
                        len =  j - i;
                    }
                } else {
                    break;
                }
            }

        }
        return result;
    }
}
