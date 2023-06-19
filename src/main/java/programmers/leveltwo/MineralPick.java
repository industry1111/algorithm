package programmers.leveltwo;

import java.util.*;

public class MineralPick {
    public static void main(String[] args) {

        //다이아몬드,철,돌 곡괭이 순
        int[] picks = {1, 1, 0};
        String[] minerals = {"iron","iron","iron","iron","stone","diamond"};

        System.out.println(solution(picks, minerals));
    }

    public static int solution(int[] picks, String[] minerals) {

        //캘 수 있는 광물의 총 개수
        int maxCnt = 0;
        for (int n : picks) {
            maxCnt += n * 5;
        }

        //광물을 돌 곡괭이로 캤을 때의 피로도 및 광물 개수 저장할 배열 선언
        int[][] tirednessArr = new int[maxCnt/5+1][2];
        int cnt = 0;
        int tiredness = 0;
        int idx = 0;
        for (int i = 0; i < minerals.length; i++) {
            //캘수 있는 광물의 개수보다 광물이 더많다면 for문 탈출
            if(i>= maxCnt){
                break;
            }
            switch (minerals[i]){
                case "diamond" : tiredness += 25; break;
                case "iron"    : tiredness += 5;  break;
                case "stone"   : tiredness += 1;  break;
            }
            cnt++;

            //5개씩 묶어서 총 피로도 저장(돌곡괭이로 캤을 시 기준)
            if (cnt == 5 || i == minerals.length-1) {

               tirednessArr[idx][0] = tiredness;
               tirednessArr[idx][1] = cnt;
               idx++;
               cnt = 0;
               tiredness = 0;
            }

        }

        //피로도 소모가 가장큰 광물더미를 더 좋은 곡괭이로 캐기 위해 역순으로 정렬
        Arrays.sort(tirednessArr, Comparator.comparingInt((int[] a) -> a[0]).reversed().thenComparingInt(a -> a[1]));

        int answer = 0;
        
        for(int[] arr : tirednessArr){
            for (int i = 0; i < picks.length; i++) {
                if(picks[i] == 0) {
                    continue;
                }
                switch (i) {
                    case 0:
                        answer += arr[1];
                        break;
                    case 1:
                        answer += Math.max(arr[0] / 5 + arr[0] % 5, arr[1]) ;
                        break;
                    case 2:
                        answer += arr[0];
                        break;
                }
                picks[i]--;
                break;
            }
        }

        return answer;
    }
}
