package programmers.leveltwo.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*프로그래머스 level2 영어 끝말잇기
* 문제
* https://programmers.co.kr/learn/courses/30/lessons/12981
* 입출력 예
* n	words	result
* 3	[tank, kick, know, wheel, land, dream, mother, robot, tank]	[3,3]
* 5	[hello, observe, effect, take, either, recognize, encourage, ensure, establish, hang, gather, refer, reference, estimate, executive]	[0,0]
* 2	[hello, one, even, never, now, world, draw]	[1,3]
*/
public class WordChainGame {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};

        System.out.println(Arrays.toString(solution(n,words)));
    }

    public static int[] solution(int n, String[] words) {
        Set<String> wordsInGame = new HashSet<>();

        int turn = 0;
        int people = 0;
        char firstCh = ' ', lastCh = ' ';
        for (int i = 0; i < words.length; i++) {

            //말하는 사람의 순서
            people = (i+1) % n != 0 ? (i%n)+1 : n;
            //n 번째 턴
            turn = (int) Math.ceil((double)(i+1) / n);
            //첫번째 알파벳
            firstCh = words[i].charAt(0);
            System.out.println("firstAlphabet = " + firstCh+", lastAlphabet = "+ lastCh);
            if (!wordsInGame.isEmpty() && (wordsInGame.contains(words[i]) || lastCh != firstCh)) {
                return new int[]{people, turn};
            } else {
                wordsInGame.add(words[i]);
                lastCh = words[i].charAt(words[i].length()-1);
            }
        }

        return new int[]{0, 0};
    }
}
