package programmers.levelOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class numberCardGame {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=0,m=0,result=0; // N x M
        List<int[]> numList = new ArrayList<>();

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i=0; i<n; i++){
            sc.nextLine();
            int[] numArr = new int[m];
            for (int j=0; j<numArr.length; j++){
                numArr[j] = sc.nextInt();
            }
            Arrays.sort(numArr);
            if( numArr[0] > result ){
                result = numArr[0];
            }
//            result = Math.max(numArr[0],result);
        }

        System.out.println(result);
    }
}
