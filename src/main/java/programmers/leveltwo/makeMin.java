package programmers.leveltwo;

public class makeMin {
    public static void main(String[] args) throws IOException {

        int[] A,B = null;

        System.out.println(solution(A,B));
    }

    public int solution(int []A, int []B)
    {
        int answer = 0;
        int len = A.length-1;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0; i<=len; i++){
            answer += A[i]*B[len-i];
        }
        return answer;
    }

}
