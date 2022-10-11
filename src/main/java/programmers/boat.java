package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boat {
    public static void main(String[] args) throws IOException {
        int[] people = {70,50,50,30};
        int limit  = 100;
        int cnt = 0;
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
        for (int i=0; i<people.length;i++){
            for (int j=i+1; j<people.length-1; j++){
                System.out.println(people[j]);
                if ((people[i] + people[j])<= limit){
                    cnt++;
                    people[j] = limit+1;
                    break;
                }
                if (people[j] != limit+1)
                    cnt++;
            }
        }
        if (people[people.length-1] <limit)
            cnt++;
        System.out.println(cnt);
    }

    public void sort(int[] ints){
        for(int i=0; i<ints.length-1; i++){
            for (int j=i+1; j<ints.length; j++){

            }
        }
    }
}
