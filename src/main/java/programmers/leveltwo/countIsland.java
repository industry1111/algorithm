package programmers.leveltwo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
* 메리는 여름을 맞아 무인도로 여행을 가기 위해 지도를 보고 있습니다. 지도에는 바다와 무인도들에 대한 정보가 표시돼 있습니다.
*  지도는 1 x 1크기의 사각형들로 이루어진 직사각형 격자 형태이며, 격자의 각 칸에는 'X' 또는 1에서 9 사이의 자연수가 적혀있습니다.
* 지도의 'X'는 바다를 나타내며, 숫자는 무인도를 나타냅니다. 이때, 상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룹니다.
* 지도의 각 칸에 적힌 숫자는 식량을 나타내는데, 상, 하, 좌, 우로 연결되는 칸에 적힌 숫자를 모두 합한 값은
* 해당 무인도에서 최대 며칠동안 머물 수 있는지를 나타냅니다.
* 어떤 섬으로 놀러 갈지 못 정한 메리는 우선 각 섬에서 최대 며칠씩 머물 수 있는지 알아본 후 놀러갈 섬을 결정하려 합니다.
* 지도를 나타내는 문자열 배열 maps가 매개변수로 주어질 때,
* 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return 하는 solution 함수를 완성해주세요.
*  만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return 해주세요.
*
*
* Input (maps)	                        return (result)
* ["X591X","X1X5X","X231X", "1XXX1"]	[1, 1, 27]
* ["XXX","XXX","XXX"]	                   [-1]
* */
public class countIsland {
    static int col;
    static int row;
    static String[] arr;
    static int result;

    private static boolean dfs(int x, int y,int sum) {

        if ( x < 0 || x >= row || y < 0 || y >= col || arr[x].charAt(y) == 'X' ) return false;

            StringBuilder str = new StringBuilder(arr[x]);
            if (arr[x].charAt(y) != 'Y' ) {

                result += arr[x].charAt(y)-48;
                str.setCharAt(y, 'Y');
                arr[x] = String.valueOf(str);

                dfs(x, y - 1,result);
                dfs(x - 1, y,result);
                dfs(x, y + 1,result);
                dfs(x + 1, y,result);

                return true;
            }

            return false;
    }

    public static void main(String[] args) {
        arr = new String[] {"5X2X39","9XXX32","X9X33X", "X4X93X"};
        col = arr[0].length();
        row = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<row;i++) {
            for (int j=0; j<col; j++) {
                result = 0;
                if (dfs(i,j,result)) {
                    list.add(result);
                }
            }
        }
        int idx = 0;

        int[] intArr = new int[list.size()];
        for (Integer integer : list) {
            intArr[idx++] = integer;
        }
        System.out.println(Arrays.toString(intArr));
        sort(intArr);
    }

    private static void sort (int[] arr) {

        int tmp = 0;
        int min = 0;
//        for (int i=0; i<arr.length; i++) {
//            for ( int j=i+1; j<arr.length; j++) {
//                if ( arr[i] > arr[j]) {
//                    tmp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = tmp;
//                }
//            }
//        }
        for (int i=0; i<arr.length-1; i++) {
            min = i;
            for ( int j=i+1; j<arr.length; j++) {
                if ( arr[min] > arr[j]) {
                    min = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
            System.out.println(Arrays.toString(arr));
        }
    }
}


