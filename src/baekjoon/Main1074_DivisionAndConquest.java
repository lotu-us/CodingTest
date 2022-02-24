package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1074_DivisionAndConquest {

    static int count  = -1;
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
        System.out.println(count);
    }

    private static void partition(int startX, int startY, int size) {
        if(find == false){
            if(size <= 2){
                find = findXY(startX, startY);
                return;
            }
        }else{
            return;
        }

        //4등분
        size  = size / 2;
        partition(startX,                    startY,     size);    //좌측상단
        partition(startX+size,        startY,      size);    //우측상단
        partition(startX,             startY+size, size);    //좌측하단
        partition(startX+size, startY+size, size);    //우측하단
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
