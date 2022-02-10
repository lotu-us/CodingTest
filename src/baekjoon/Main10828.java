package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

interface Stack{
    void push(int n);
    int pop();
    int size();
    int empty();
    int top();
}

//배열로 stack 구현
class ArrayStack implements Stack{
    int[] store;
    int index = 0;

    //초기값이 필요하다
    public ArrayStack(int storeLength) {
        store = new int[storeLength];
    }

    @Override
    public void push(int n){
        store[index] = n;
        index++;
    }

    @Override
    public int pop(){
        int result = top();
        if(size()>0){
            store[index-1] = 0;
            index--;
        }
        return result;
    }

    @Override
    public int size(){
        return index;
    }

    @Override
    public int empty(){
        if(this.size() == 0){
            return 1;
        }
        return 0;
    }

    @Override
    public int top(){
        if(this.size() == 0){
            return -1;
        }
        return store[index-1];
    }
}

//LinkedList로 Stack구현
class LinkedStack implements Stack{
    LinkedList<Integer> store = new LinkedList<Integer>();

    @Override
    public void push(int n) {
        store.add(n);
    }

    @Override
    public int pop() {
        int result = top();
        if(size() >= 1){
            store.removeLast();
        }
        return result;
    }

    @Override
    public int size() {
        return store.size();
    }

    @Override
    public int empty() {
        if(size() == 0){
            return 1;
        }
        return 0;
    }

    @Override
    public int top() {
        if(size() == 0){
            return -1;
        }
        return store.getLast();
    }
}



public class Main10828 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(br.readLine());
        ArrayStack stack = new ArrayStack(commandCount);
        //LinkedStack stack = new LinkedStack();

        for (int i = 0; i < commandCount; i++) {
            String command = br.readLine();
            int num = 0;

            if(command.contains(" ")){
                StringTokenizer st = new StringTokenizer(command, " ");
                command = st.nextToken();
                num = Integer.parseInt(st.nextToken());
            }

            switch(command){
                case "push" :
                    stack.push(num); break;
                case "pop" :
                    System.out.println("pop : " + stack.pop()); break;
                case "size" :
                    System.out.println("size : " + stack.size()); break;
                case "empty" :
                    System.out.println("empty : " + stack.empty()); break;
                case "top" :
                    System.out.println("top : " + stack.top()); break;
            }
        }

    }
}
