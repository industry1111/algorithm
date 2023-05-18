package programmers.levelOne;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FrequencyScore {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트케이스 수
        int T = Integer.parseInt(br.readLine());


        for(int test_case = 1; test_case <=T; test_case++) {

            int caseNum = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            //점수별 입력횟수를 저장하기 위에 맵 선언
            Map<Integer,Integer> scoresCnt = new HashMap<>();
            scoresCnt.put(101,0);
            //가장 많이 나온 점수
            int mostCmmScore = 101;

            while (st.hasMoreTokens()) {
                int score = Integer.parseInt(st.nextToken());

                //점수별 빈도 입력
                if(scoresCnt.containsKey(score)) {
                    scoresCnt.put(score,scoresCnt.get(score)+1);
                } else {
                    scoresCnt.put(score,1);
                }

                //가장 입력이 많이된 점수 찾기
                if ( scoresCnt.get(score) > scoresCnt.get(mostCmmScore) ) {
                    mostCmmScore = score;
                } else if (scoresCnt.get(score) == scoresCnt.get(mostCmmScore)) {
                    mostCmmScore = Math.max(mostCmmScore, score); //같은 빈도인 점수가 있으면 높은 점수 출력
                }

            }
            System.out.println("#"+test_case+" " + mostCmmScore);
        }



    }
}
