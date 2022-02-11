package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main9012 {
    /*
    * (와 )개수가 같으면 : YES : stack이 비어있음
    * (가 )보다 많으면 : NO : stack에 남아있음
    * (가 )보다 작으면 : NO : stack에 남아있음
    *
    * ( push
    * ) pop -> 에러 발생하면 무조건 NO
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < commandCount; i++) {
            Stack<Character> stack = new Stack<Character>();
            char[] chars = br.readLine().toCharArray();
            boolean check = true;

            for (char c : chars) {
                if( c == '(' ) {
                    stack.push(c);
                }else{
                    try{
                        stack.pop();
                    }catch (Exception e){
                        check = false;
                        break;
                    }
                }
                //System.out.println("c : "+c+" | "+stack);
            }

            if(stack.empty() && check){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }


    }
}
