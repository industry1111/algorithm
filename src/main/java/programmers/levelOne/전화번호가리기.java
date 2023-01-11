package programmers.levelOne;

public class 전화번호가리기 {
    public static void main(String[] args) {
        String phone_number = "01022223333";
        solution(phone_number);
    }

    public static void solution ( String phone_number ) {

        String answer = "";
        int len = phone_number.length()-4;
        for ( int i=0; i<len; i++){
            answer += "*";
        }
        answer += phone_number.substring(len);
        System.out.println("answer  :" + answer);

        //정규표현식 사용
        //   .  무작위 문자
        //   ?= 제외
        //   .{m,n} : 무작위 문자가 m~n 만큼
        //   ex) a{2,3}  : 'aa' , 'aaa' 제외
        //   https://en.wikipedia.org/wiki/Regular_expression 참고
        //   {m,n}	Matches the preceding element at least m and not more than n times. For example, a{3,5} matches only "aaa", "aaaa", and "aaaaa". This is not found in a few older instances of regexes. BRE mode requires \{m,n\}.
        System.out.println("regex :" + phone_number.replaceAll(".(?=.{4})", "*"));
    }
}
