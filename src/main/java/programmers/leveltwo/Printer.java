package programmers.leveltwo;

import java.util.*;

public class Printer {
    public static void main(String[] args) {
        int[] list = {1,1,9,1,1};
        int location =1;


        Directory minDir = new Directory(0,101);
        Stack<Directory> stack = getStack(list);

        for(int i=0; i<list.length; i++){
            if ( minDir.prioritiy > list[i] ) {
                minDir.location = i;
                minDir.prioritiy = list[i];
            }
            stack.push(new Directory(i,list[i]));
        }

        System.out.println(minDir.toString());
        int result = 0;
        while (!stack.empty()){
            stack.pop();
        }
    }

    private static Stack<Directory> getStack(int[] list){

        Stack<Directory> stack = new Stack<>();


        return stack;
    }
}

class Directory {
    int location;
    int prioritiy;

    public Directory() {

    }

    public  Directory(int inptLoacation, int inptPrioritiy) {
        this.location = inptLoacation;
        this.prioritiy = inptPrioritiy;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "location=" + location +
                ", prioritiy=" + prioritiy +
                '}' +'\n';
    }
}
