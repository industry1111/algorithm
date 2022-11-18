package Al;

/*문제 거스름돈
    당신은 음식점의 계산을 도와주는 점원입니다. 카운터에는 거스름돈으로 사용할 500원,100원,50원,10원짜리 동전히 무한히 존재한다고 가정합니다.
    손님에게 거슬러 주어야 할 돈이 N원일 때 거슬러 주어야 할 동전의 최소 개수를 구하세요. 단, 거슬러 줘야 할 돈 N은 항상 10의 배수 입니다.
 */

public class Greedy {
    public static void main(String[] args) {
        int[] arr = {500,100,50,10};
        int input = 1260;
        int cnt = 0;
        for ( int n : arr) {
            cnt += input / n ;
            input %= n;
        }
        System.out.println(cnt);
    }
}
/*
   화폐의 종류가 K라고 할 때, 소스코드의 시간 복잡도는 O(K)
   시간복잡도는 금액과 무관, 동전의 총 종류에만 영향
 */