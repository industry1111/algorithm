package programmers.leveltwo.stack;


import java.util.*;

/*
문제
운영체제의 역할 중 하나는 컴퓨터 시스템의 자원을 효율적으로 관리하는 것입니다. 이 문제에서는 운영체제가 다음 규칙에 따라 프로세스를 관리할 경우 특정 프로세스가 몇 번째로 실행되는지 알아내면 됩니다.

1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
  3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.

예를 들어 프로세스 4개 [A, B, C, D]가 순서대로 실행 대기 큐에 들어있고, 우선순위가 [2, 1, 3, 2]라면 [C, D, A, B] 순으로 실행하게 됩니다.
현재 실행 대기 큐(Queue)에 있는 프로세스의 중요도가 순서대로 담긴 배열 priorities와, 몇 번째로 실행되는지 알고싶은 프로세스의 위치를 알려주는 location이 매개변수로 주어질 때, 해당 프로세스가 몇 번째로 실행되는지 return 하도록 solution 함수를 작성해주세요.

1<= priorities <=100
priorities in (1~9)

0 <= locatoion <= priorities.length-1
 */
public class ProcessScheduling {
    public static void main(String[] args) {

        int[] priorities = {2,1,3,2};
        int location = 2;
        int answer = 0;

        // 입력된 priorites(우선순위)를 index와 priorites 형식으로 변경
        // queue에 입력
        Queue<Directory> queue = new LinkedList<>();
        int index = 0;
        for (int priority : priorities) {
            Directory directory = new Directory(index++,priority);
            queue.add(directory);
        }

        //loaction의 출력 순서
        answer = getIndex(queue,location);

        System.out.println(answer);
    }

    static int getIndex(Queue<Directory> queue,int location) {
        int result = 0;

        while (!queue.isEmpty()) {
            Directory directory = queue.poll();
            int n = directory.priority;
            boolean flag = true;

            //큐에 우선순위가 높은 문서가 존재하면 큐 끝에 추가
            for (Directory d : queue) {
                if (d.priority > n) {
                    queue.add(directory);
                    flag = false;
                    break;
                }
            }

            //우선 순위 높은 문서가 없다면 카운트 증가
            // 해당 인덱스와 입력받은 location이 같다면  while문 탈출
            if (flag) {
                result++;
                if (directory.index == location) {
                    break;
                }
            }
        }
        return result;
    }
    static class Directory {
        int index = 0;
        int priority = 0;

        public Directory(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
        @Override
        public String toString() {
            return "Directory{" +
                    "index='" + index + '\'' +
                    ", priority=" + priority +
                    '}';
        }
    }
}

