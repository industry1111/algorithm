package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class maxminNum {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.println(solution(br.readline()));

    }
    public String solution(String s) {
        String[] arr = s.split(" ");

        int min = Integer.parseInt(arr[0]);
        int max = Integer.parseInt(arr[0]);

        int num = 0;

        for(int i=0; i<arr.length; i++){
            num = Integer.parseInt(arr[i]);
            if(num < min) {
                min = num;
            }

            if(num > max){
                max = num;
            }
        }
        return min + " " + max;
    }

}