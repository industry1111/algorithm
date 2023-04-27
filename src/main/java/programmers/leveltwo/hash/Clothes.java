package programmers.leveltwo.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Clothes {
    public static void main(String[] args) {

        //같은 이름을 가진 의상은 존재하지 않음
        //의상의 종류는 얼굴,상의,하의.겉옷 4가지
        String[][] clothes = {{"yellow_hat", "top"}, {"blue_sunglasses", "eyewear"},{"green_turban", "headgear"},{"yellow_hat2", "headgear"}};

        System.out.println(solution(clothes));
    }

    private static int solution(String[][] clothes) {

        int combinationCount = 1;

        Map<String,Integer> numClothes = new HashMap<>();

        for ( int i=0; i<clothes.length; i++ ) {
            String type = clothes[i][1];

            if ( !numClothes.containsKey(type) ) {
                numClothes.put(type,1);
            } else {
                numClothes.put(type,numClothes.get(type)+1);
            }
        }
        for (String str : numClothes.keySet() ) {
            combinationCount *= numClothes.get(str)+1; // 종류별로 옷을 안입는 경우 추가
        }


        return combinationCount-1; // 다 안입은 경우
    }


    //stream 참고용
    private static int solution2(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }
}
