package javaBasic;

import java.util.*;

public class hashStackQueue {
    public static  void  main (String[] args){
        String[] a = {"a","b","c","d","e"};
        String[] b = {"a","b","c","d","f"};

//        System.out.println(getHashMap(a,b).toString());
//        System.out.println(getStack(a));
        System.out.println(getQueue(a).toString());
    }
    /*
        getOrDefault(key,defaultValue) : 해당 key의 value를 리턴, 해당 key가 없다면 defaultValue 리턴
        putifAbsent(key,value) :  해당 key의 value를 리턴 , 해당 key가 없다면 null을 리턴하며, map에 key와 value를 add
    */
    private static HashMap<String,Integer> getHashMap (String[] strA, String[] strB){
        HashMap<String,Integer> hMap = new HashMap<String,Integer>();


        for (String str : strA) {
            hMap.put(str,1);
        }
        System.out.println(hMap.toString());

        for (String str : strB) {
            System.out.println(hMap.putIfAbsent(str,3));
//            System.out.println(hMap.getOrDefault(str,2));
        }
        System.out.println(hMap.toString());

        return hMap;
    }


    /*
    empty() :  boolean 값 리턴
    peek()   : 스택의 최상의 값을 제거 없이 꺼냄
    push()   : add
    pop()    : get and remove
    search(Object o) : 위에서 부터 o의 위치를 반환(1부터 시작) 해당 값이 없으면 -1 리턴
    */
    private static Stack<String> getStack(String[] strA) {
        Stack<String> stack = new Stack<String>();

        System.out.println("before push stack.empty() : " + stack.empty() );
        for (String str : strA ) {
            stack.push(str);
        }
        System.out.println("after push stack.empty() : " + stack.empty() );
        System.out.println("pop stack : " + stack.pop());
        System.out.println("peek stack : " + stack.peek());
        System.out.println("search (b) : " + stack.search("b"));
        System.out.println("search (e) : " + stack.search("e"));

        return stack;
    }

    /*  예외처리       값리턴
    *   add()     :  offer(e)
        remove()  :  poll()
        Examine() :  peek()

    * */
    private static Queue<String> getQueue (String[] strA){

        Queue<String> queue = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        for (String str : strA) {
            queue2.add(str);
        }
        System.out.println("queue.poll() : " + queue.poll());
        System.out.println("queue.peek() : " + queue.peek());
        System.out.println("queue2.remove() : " + queue2.remove());
        System.out.println("queue2.poll() : " + queue2.poll());
        System.out.println("queue2.element() : " + queue2.element());
        System.out.println("queue2 : " + queue2);
        return queue2;
    }


}
