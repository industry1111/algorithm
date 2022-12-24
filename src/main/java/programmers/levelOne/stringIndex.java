package programmers.levelOne;
//문제 설명
//
//문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
//제한 조건
//strings는 길이 1 이상, 50이하인 배열입니다.
//strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
//strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
//모든 strings의 원소의 길이는 n보다 큽니다.
////인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
//입출력 예
//strings	n	return
//["sun", "bed", "car"]	1	["car", "bed", "sun"]
//["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class stringIndex {
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<String> strList = new ArrayList<>();

        while (st.hasMoreTokens()){
            strList.add(st.nextToken());
        }
        Collections.sort(strList);
        int n = 2;
        String tmpStr = null;
        String str = null;
        String cmpStr = null;
        for (int i=0; i <strList.size()-1; i++){
            for ( int j=i+1; j <strList.size(); j++){
                str = strList.get(i);
                cmpStr = strList.get(j);
                if ( str.charAt(n) > cmpStr.charAt(n)){
                    tmpStr = str;
                    strList.set(i,cmpStr);
                    strList.set(j,tmpStr);
                }

            }
        }
        System.out.println(Arrays.toString(strList.toArray()));

    }
}
