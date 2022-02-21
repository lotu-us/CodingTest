package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
1일 : UP & DOWN ( A - B )
2일 : UP & DOWN ( A - B )
3일 : UP & DOWN ( A - B )
n-1일 : UP & DOWN ( A - B )
n일 : ONLY UP ( A )
( A - B ) ( n - 1 ) + A >= V
*/
public class Main2869_math {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long UP = Long.parseLong(st.nextToken());
        long DOWN = Long.parseLong(st.nextToken());
        long HEIGHT = Long.parseLong(st.nextToken());
        long day = 0L;
        long current = 0L;

//        while(true){
//            day++;
//            current = current + UP;
//            System.out.println(current);
//            if( current >= HEIGHT ){
//                break;
//            }
//            current = current - DOWN;
//        }
        day = (HEIGHT - DOWN) / (UP - DOWN);
        if( (HEIGHT - DOWN) % (UP - DOWN) != 0 ){
            day++;
        }

        System.out.println(day);

    }

}
