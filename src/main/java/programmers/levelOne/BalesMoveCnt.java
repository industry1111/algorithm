package programmers.levelOne;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class BalesMoveCnt {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트케이스 수
        int T = Integer.parseInt(br.readLine());


        for(int test_case = 1; test_case <=T; test_case++) {

            //건초더미 개수 변수 선언
            int baleCnt = Integer.parseInt(br.readLine());

            //건초더미별 크기를 담을 배열 선언
            int[] bales = new int[baleCnt];

            //건초들의 총 크기 변수 선언
            int totalSize = 0;

            //평균 크기 변수 선언
            int avgSize = 0;

            //총 크기 구하는 로직
            for(int i=0; i<baleCnt; i++) {
                //건초더미 크기 입력
                int baleSize = Integer.parseInt(br.readLine());
                //건초더미별 크기 배열에 입력
                bales[i] = baleSize;
                //총 크기
                totalSize += baleSize;
            }

            //더미 평균 크기
            avgSize = totalSize/baleCnt;

            //움직인 횟수
            int movecnt = 0;

            for(int idx=0 ; idx< baleCnt; idx++) {
                int size = bales[idx];
                if(size > avgSize) {
                    movecnt += size-avgSize;
                }
            }

            System.out.println("#"+test_case+" "+movecnt);

        }

    }

}
