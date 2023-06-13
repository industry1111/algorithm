package programmers.leveltwo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MissileDefenseSystem {
    public static void main(String[] args) {
        int[][] ints = {{4, 5}, {4, 5}};

        System.out.println(solution(ints));
    }

    private static int solution(int[][] arr) {
        Arrays.sort(arr, Comparator.comparing(a -> a[1 ]));

        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints ));

        }

        int result =0;

        int s = 0, e = 0;

        for (int i = 0; i < arr.length; i++) {
            s = arr[i][0];

            //범위 만족시 다음 타겟 확인
            if (e > s && arr[i][1] >= e)  {
                continue;
            }

            //새로운 미사일 발사
            result++;
            e = arr[i][1];
        }
        return result;
    }
}
