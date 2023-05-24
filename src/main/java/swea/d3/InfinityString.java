package swea.d3;

public class InfinityString {

    public static String getPattern(String text) {

        int n = text.length();

        // 문자열의 길이가 1 이하인 경우는 패턴으로 처리하지 않음
        if (n <= 1) {
            return text;
        }

        String pattern = "";

        for (int i = 1; i <= n / 2; i++) {
            // 문자열 처음부터 패턴확인
            String currentPattern = text.substring(0, i);

            // 해당 패턴으
            if (text.matches("(" + currentPattern + ")+")) {
                pattern = currentPattern;
                break;
            }
        }

        return pattern.isEmpty() ? text : pattern;
    }

}
