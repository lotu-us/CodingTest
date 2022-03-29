package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main7576_bfs {
/*
익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다.

정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
* */
    static int[][] tomatos = null;
    static Queue<int[]> queue = new LinkedList<>();
    static int W = 0;
    static int H = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomatos = new int[W][H];

        //값 입력받기
        for (int h = 0; h < H; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < W; w++) {
                tomatos[w][h] = Integer.parseInt(st.nextToken());

                if(tomatos[w][h] == 1){
                    queue.offer(new int[]{w, h});
                    //익은 토마토 위치 큐에 담는다. (익은 토마토가 여러개면 동시다발적으로 주변이 익기때문)
                }
            }
        }

        bfs();
        System.out.println(days());

    }

    private static void bfs() {

        int[] X = {0, 0, -1, +1};
        int[] Y = {-1, +1, 0, 0};
        //상하좌우

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int tempX = poll[0] + X[i];
                int tempY = poll[1] + Y[i];

                if(tempX < 0 || tempX >= W || tempY < 0 || tempY >= H){
                    //좌표가 tomatos의 범위를 넘어가면면
                    continue;
                }

                if(tomatos[tempX][tempY] == 0){
                    queue.offer(new int[]{tempX, tempY});
//                    tomatos[tempX][tempY] = 1;
                    //익은 날짜를 입력함. 그 전의 값에서 +1
                    tomatos[tempX][tempY] = tomatos[poll[0]][poll[1]] + 1;
                }
            }
        }

    }

    private static int days(){
        int max=0;
        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                //토마토 안익은게 있으면
                 if(tomatos[w][h] == 0){
                     return -1;
                 }

                 //토마토가 모두 익었다면 날짜의 최대값 가져오기
                 max = Math.max(max, tomatos[w][h]);
            }
        }

        return max-1; //1부터 시작했으니까 -1
    }

}
