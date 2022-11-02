package programmers.leveltwo;

class expressions {
    public int solution(int n) {

        int j,cnt, sum ;
        cnt=0;

        for(int i=1; i<=n/2; i++){
            sum=0;
            j = i;
            while (sum<n){
                sum += j;
                j++;
            }
            if (sum == n) {
                cnt++;
            }
        }
        cnt++;
        return cnt;
    }

    //수학적 접근 방법
    //--생각하지도 못한 방법
    //주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리
    public int expressions(int num) {
        int answer = 0;
        for (int i = 1; i <= num; i += 2) {
            if (num % i == 0) {
                answer++;
            }
        }
        return answer;
    }

}