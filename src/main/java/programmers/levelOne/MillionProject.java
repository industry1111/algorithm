package programmers.levelOne;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 1. 원재는 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다.
 2. 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다.
 3. 판매는 얼마든지 할 수 있다.
*/
public class MillionProject {
    public static void main(String[] args) throws Exception{
        File file = new File("/Users/gohyeong-gyu/Downloads/input.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);

        int T;

        T = Integer.parseInt(br.readLine());


        String[] prices;
        Stack<Integer> priceStack = new Stack<>();

        for (int test_case = 1; test_case <= T; test_case++) {
            int len = Integer.parseInt(br.readLine());
            prices = br.readLine().split(" ");

            for (int i=0; i<len; i++) {
                priceStack.push(Integer.parseInt(prices[i]));
            }

            int maxPrice  = priceStack.pop();
            long income = 0;

            while (!priceStack.isEmpty()) {
                int price = priceStack.pop();
                if(maxPrice > price) {
                    income += maxPrice-price;
                } else {
                    maxPrice = price;
                }
            }
            System.out.println("#"+test_case+" "+income);
        }

    }
}
