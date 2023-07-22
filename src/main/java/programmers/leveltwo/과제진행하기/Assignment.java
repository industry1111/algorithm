package programmers.leveltwo.과제진행하기;

import java.util.*;


/* 현재 접근 방법
* 1. 시작시간(start)이 빠른 순으로 정렬
* 2. 현재 과제의 start + playTime 와 다음 과제의 start 비교
* 3. 다음 과제의 start 시간이 더 빠르다면 현재 과제의 start는 다음과제의 start로 변경, playTime은 현재 과제의 start+playTime - 다음 과제의 start
* 4. 다음 과제의 start 시간이 더 늦다면 다음과제 시작
* 5. 위의 과정 반복
* */
public class Assignment {
    public static void main(String[] args) {
        String[][] subjects =	{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};

        System.out.println(Arrays.toString(solution(subjects)));
    }

    private static String[] solution(String[][] plans) {

        String[] result = new String[plans.length];
        int index =0;

        //시작시간 빠른 순으로 정렬
        Arrays.sort(plans, Comparator.comparing(a -> stringToInt(a[1])));

        //역순으로 정렬
        Collections.reverse(Arrays.asList(plans));

        //진행해야할 과제들을 저장할 스택 선언

        Deque<Subject> progressSubjects = new LinkedList<>();
        for (String[] subject : plans) {
            String name = subject[0];
            int start = stringToInt(subject[1]);
            int playTime = Integer.parseInt(subject[2]);

            progressSubjects.offerFirst(new Subject(name, start, playTime));
        }

        Subject currentSubject = progressSubjects.pollLast();
        int endTime = getEndTime(currentSubject.getStart(), currentSubject.getPlayTime());
        //과제 진행
        while (!progressSubjects.isEmpty()) {

            Subject nextSubject = progressSubjects.pollLast();
            int nextStartTime = nextSubject.getStart();


            if (endTime >= nextStartTime) {

                //종료시간과 다음과제의 시작시각인 같을 경우에는 현재과제완료 처리후 다음과제 진행
                if ( endTime == nextStartTime) {
                    System.out.println(" = =================");
                    result[index++] = currentSubject.getName();
                    currentSubject = nextSubject;
                    endTime = getEndTime(currentSubject.getStart(), currentSubject.getPlayTime());

                    continue;
                }

                currentSubject.setStart(nextStartTime);
                currentSubject.setPlayTime(currentSubject.getStart() + currentSubject.getPlayTime() - nextStartTime);
//                progressSubjects.offerFirst(currentSubject);

                currentSubject = nextSubject;
                endTime = getEndTime(currentSubject.getStart(), currentSubject.getPlayTime());
                System.out.println("nextSubject = " + currentSubject.getName() + " , " + currentSubject.getStart());
            } else { // 종료시간보다 다음과제의 시작시각이 더 늦을 경우 멈춰둔 과제 리스트확인

                result[index++] = currentSubject.getName();

                currentSubject = progressSubjects.pollFirst();
                endTime = getEndTime(currentSubject.getStart(), currentSubject.getPlayTime());

            }


        }
        result[index++] = currentSubject.getName();
        return result;
    }

    public static int stringToInt(String time) {
        return Integer.parseInt(time.replace(":", ""));
    }

    public static int getEndTime(int start, int playTime) {
        int hour = start / 100;
        int minute = start % 100;

        int endHour = (minute + playTime) / 60;
        int endMinute = (minute + playTime) % 60;

        return (hour + endHour) * 100 + endMinute;
    }


}


class Subject {
    private String name;
    private int start;
    private int playTime;

    public Subject(String name, int start, int playTime) {
        this.name = name;
        this.start = start;
        this.playTime = playTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }
}


