package programmers;


import java.util.Deque;
import java.util.LinkedList;


public class Soution {
    public static void main(String[] args){
        int answer = 0;

        int a = 1;
        int b = 7;

        if (a % 2 == 1) a++;
        if (b % 2 == 1) b++;

        answer = ( b/2 - a/2 ) +1;


        System.out.println(answer);
    }

}
