package programmers.leveltwo;

public class makeJadenCaseString {
    public static void main(String[] args) throws IOException {

        String s = "For The Last Week";
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        if ( 96 < arr[0] && arr[0] < 122) {
            arr[0] -= 32;
        }
        for( int i=1; i<arr.length-1; i++ ){
            if(arr[i] == 32){
                i++;
                if ( 96 < arr[i] && arr[i] < 122) {
                    arr[i] -= 32;
                }
                if(arr[i] == 32) {
                    i--;
                }
            }
        }
        return String.valueOf(arr);
        //테스트케이스 8,9번 충족 못함
    }

}
