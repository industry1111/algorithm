package javaBasic;// 이것이 코딩 테스트다. p111 상하좌우문제
import java.util.Scanner;

public class LRUD {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int inptNum = sc.nextInt();
        sc.nextLine();
        String inptString = sc.nextLine();

//        firstLRUD(inptNum,inptString);
    }

    private static void firstLRUD(int n, String str){

        int x = 1; //행 row
        int y = 1; //열 column

        for (char ch :
                str.toCharArray()) {
            switch (ch) {
                case 'L' : if (y > 1 ) y--;
                    break;
                case 'R' : if ( y <= n ) y++;
                    break;
                case 'U' : if ( x > 1 ) x--;
                    break;
                case 'D' : if ( x <= n ) x++;
                    break;
                default:
                    break;
            }
        }
        System.out.println(x + " " + y);
    }
}

