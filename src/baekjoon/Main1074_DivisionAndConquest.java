package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1074_DivisionAndConquest {

    static int count  = 0;
    static int findX;
    static int findY;
    static boolean find = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        findY = Integer.parseInt(st.nextToken());       //열
        findX = Integer.parseInt(st.nextToken());       //행
        int size = (int) Math.pow(2, N);
        //===============================
        //입력완료

        partition(0, 0, size);
        System.out.println(count-1);
    }

    private static void partition(int startX, int startY, int size) {
        if(size <= 2){
            findXY(startX, startY);
            return;
        }

        int half = size/2;
        boolean left =          startX <= findX && findX < startX + half;
        boolean right =  startX + half <= findX && findX < startX + size;
        boolean top =           startY <= findY && findY < startY + half;
        boolean bottom = startY + half <= findY && findY < startY + size;


        if(left && top){
            partition(startX, startY, half);
        }else if(right && top){
            count = count + ((half * half) * 1);
            partition(startX+half, startY, half);
        }else if(left && bottom){
            count = count + ((half * half) * 2);
            partition(startX, startY+half, half);
        }else if(right && bottom){
            count = count + ((half * half) * 3);
            partition(startX+half, startY+half, half);
        }

    }


    private static boolean findXY(int startX, int startY){

        //Z 방향으로 확인
        for (int j = startY; j < startY + 2; j++) {     //Y가 먼저
            for (int i = startX; i < startX+2; i++) {
                count++;
                if (i == findX && j == findY) {
                    return true;
                }
            }
        }

        return false;
    }

}
