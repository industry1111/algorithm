package programmers.levelOne;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MemoryScore {
    public static void main ( String[] args ) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning= {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        System.out.println(Arrays.toString(solution(name,yearning,photo)));
    }

    private static int[] solution(String[] names, int[] yearning, String[][] photo) {

        int[] answer = new int[photo.length];
        Map<String,Integer> yearningOfName = new HashMap<>();

        for (int idx = 0; idx<names.length; idx++ ) {
            yearningOfName.put(names[idx],yearning[idx]);
        }

        int yearningScore;
        String name = "";
        for ( int i=0; i<photo.length; i++ ) {

            yearningScore = 0;

            for ( int j=0; j<photo[i].length; j++ ) {

                name = photo[i][j];
                if ( yearningOfName.containsKey(name)) {
                    yearningScore += yearningOfName.get(name);
                }
            }

            answer[i] = yearningScore;

        }
        return answer;
    }
}
