//입력값 〉	["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]
//기댓값 〉	["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]

package programmers;

import java.util.Arrays;

public class 파일저장소 {
    public static void main(String[] args) {
        String[] strArr ={"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String tmpStr = " ";
        char ch1, ch2 = ' ';
        boolean flag = false;

        for (int i=0;i<strArr.length-1;i++){
            for (int j=0; j<strArr[i].length(); j++){
                ch1 = strArr[i].charAt(j);
                if  ( strArr[i].length() > strArr[i+1].length()) {
                    continue;
                }else {
                    ch2 = strArr[i+1].charAt(j);
                }

                if ( ch1 > ch2) {
                    flag = true;
                    break;
                }

            }
            if ( flag ) {
                System.out.print("AS :" + Arrays.toString(strArr) + ", ");
                tmpStr = strArr[i];
                strArr[i] = strArr[i+1];
                strArr[i+1] = tmpStr;
                System.out.println("to :" + Arrays.toString(strArr));
            }
        }

    }
}
