package codingTest;

public class epopcon2 {
    public static void main(String[] args) {

        String[][] testCases = {{"nomad","damon"},{"dog","hot"},{"anagram","nagaram"},{"rat","car"},{"acaccd","dcacac"}};
        boolean[] expected = {true,false,true,false,true};

        for (int i=0; i<testCases.length; i++) {
            String[] testCase = testCases[i];
            System.out.println(solution(testCase[0],testCase[1]));
//            System.out.println("expected : " + expected[i] + ", acutal : " + solution(testCase[0],testCase[1]));
        }
    }

    static boolean solution(String s, String t) {
        int[] alphabets = new int[26];

        //문자열의 길이가 다를 경우
        if (s.length() != t.length()) {
            return false;
        }

        //첫 문자열의 각각의 알파벳 카운트
        for (int i=0; i<s.length(); i++) {
            int idx = s.charAt(i)-97;
            alphabets[idx]++;
        }

        //해당하는 알파벳 카운트 -1
        for (int i=0; i<t.length(); i++) {
            int idx = t.charAt(i)-97;
            alphabets[idx]--;
        }

        //카운트가 0이 아닐 경우 false 리턴
        for (int count : alphabets) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
