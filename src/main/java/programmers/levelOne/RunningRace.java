package programmers.levelOne;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RunningRace {
    public static void main ( String[] args ) {

        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        System.out.println(Arrays.toString(solution(players,callings)));
    }

    private static String[] solution(String[] players, String[] callings) {
        String name = "";

        Map<String,Integer> playersMap = new HashMap<>();

        int cnt = 0;
        for (String str : players ) {
            playersMap.put(str,cnt++);
        }

        System.out.println(playersMap.toString());
        int idx = 0;
        for (int i=0; i<callings.length; i++ ) {
            name = callings[i]; // 불린 선수

            idx = playersMap.get(name); // 불린 선수의 현재 등수

            playersMap.put(name,idx-1); // 역전을 했으니 등수 -1
            playersMap.put(players[idx-1],idx); // 당한 선수 등수 +1

            players[idx] = players[idx-1];
            players[idx-1] = name;

        }


        return players;
    }
}
