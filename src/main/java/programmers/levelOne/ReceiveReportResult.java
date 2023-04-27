package programmers.levelOne;

import java.util.*;

public class ReceiveReportResult {
    public static void main ( String[] args ){

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(solution(id_list,report,k)));
    }

    private static int[] solution(String[] id_list, String[] report, int k) {

        int[] result = new int[id_list.length];

        Map<String, Set<String>>  reportMap = new HashMap<>();

        for (String name : id_list) { //신고 당한 사람 이름
            reportMap.put(name,new HashSet<>());
        }

        for ( String reportInfos : report ) { //신고자 정보를 Map에 저장
            String[] reportInfo = reportInfos.split(" ");
            reportMap.get(reportInfo[1]).add(reportInfo[0]);
        }

//        Map<String,Integer> countMap = new HashMap<>();
//
//        for ( String reportedUser : reportMap.keySet() ) { // 신고당한 사람의 이름
//            int cnt = 0;
//            for ( String repoter : reportMap.get(reportedUser) ) { // 몇명이 신고 했는지 카운트
//                cnt++;
//            }
//            countMap.put(reportedUser,cnt);
//        }


        for (int i = 0; i < id_list.length; i++) {
//            int count = countMap.get(id_list[i]); // 신고 당한 횟수
            if (reportMap.get(id_list[i]).size() >= k) {
                for (String reporter : reportMap.get(id_list[i])) { //신고한 사람들
                    result[Arrays.asList(id_list).indexOf(reporter)]++; //신고한 사람의 인덱스
                }
            }
        }
        return result;
    }
}
