package programmers.levelOne;

import java.util.Arrays;

public class 제일작은수제거하기 {
    public static void main(String[] args) {

        int[] arr = {4,3,2,1};

        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[] arr) {

        if ( arr.length == 1 ) {
            arr[0] = -1;
            return arr;
        }
//        if ( arr.length == 1) return new int[] {-1};

        int minIndex = getMinIndex(arr); // 가장 작은수의 인덱스 찾기

        return removeMin(arr,minIndex);
    }

    public static int getMinIndex (int[] arr) {

        int min = arr[0];   //가장 작은 수
        int index = 0;      //가장 작은 수의 인덱스
        for ( int i=1; i<arr.length; i++) {
            if ( arr[i] < min ) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static int[] removeMin ( int[] arr , int minIndex) {

        int[] result = new int[arr.length-1];

        for (int i=0; i<arr.length-1; i++) {
            if (i < minIndex) {
                result[i] = arr[i];
            } else {                    //가장 작은수의 인덱스 부터 그 다음 수의 값을 입력
                result[i] = arr[i+1];
            }
        }
        return result;
    }
}
