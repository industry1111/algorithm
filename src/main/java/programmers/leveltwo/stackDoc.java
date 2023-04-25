package programmers.leveltwo;

import java.util.Stack;

class stackDoc {
    boolean solution(String s) {
        boolean answer = true;

        char[] arr = s.toCharArray();
        int cnt = 0;
        for (int i=0; i<arr.length; i++){

            if(arr[i] == '(') {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt < 0) break;
            //answer를 false로 하는것보단 break로 for문을 나가는게...
        }

        if (cnt != 0) answer = false;

        return answer;
    }
    //stack을 사용해서 풀어보기!!
     /*
       Stack<E>
       empty()  Tests if this stack is empty.
       push(E item)
       pop() return E

       First In Last Out
       Last In First Out
    */
    boolean solution2(String s) {
        boolean answer = true;
        Stack<Integer> st = new Stack<>();
        char[] arr = s.toCharArray();

        for (int i=0; i<arr.length; i++) {
            if ( arr[i] == '(') {
                st.push(0);
            } else {
                if (!st.empty()){
                    st.pop();
                } else {
                    answer =false;
                    break;
                }
            }
        }
        if (!st.empty()) answer = false;
        return answer;
    }
}