package codingTest;

public class epopcon4 {

    public static void main(String[] args) {
        int[][] testCases = {{-1,0,3,5,9,12}, {-1,0,3,5,9,12}};
        int [] target = {9,2};

        for (int i=0; i< testCases.length; i++) {
            System.out.println(solution4(testCases[i],target[i]));
        }
    }

    static int solution4(int[] numbers, int target) {

        int result = -1;


        for (int i=0; i<numbers.length; i++) {
            //target과 일치하는 숫자가 있을 경우 result 인덱스 값으로 변경
            if (numbers[i] == target) {
                result = i;
            }
        }

        return result;
    }
}