package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {

    static int N = 0;
    static int M = 0;
    static int[][] board = null;
    static boolean[][] check = null;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        check = new boolean[N][M];

        for (int n = 0; n < N; n++) {
            char[] chars = br.readLine().toCharArray();

            for (int m = 0; m < M; m++) {
                board[n][m] = chars[m] - '0';
            }
        }
        bfs();

        System.out.println(board[N-1][M-1]);
    }

    private static void bfs() {
        queue.offer(new int[]{0, 0});
        check[0][0] = true;

        //상하좌우
        int[] dx = new int[]{0, 0, -1, +1};
        int[] dy = new int[]{-1, +1, 0, 0};

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int X = poll[0] + dx[i];
                int Y = poll[1] + dy[i];

                //좌표를 벗어날때
                if(X < 0 || X >= N || Y < 0 || Y >= M){
                    continue;
                }

                if(board[X][Y] == 1 && check[X][Y] == false){
                    queue.offer(new int[]{X, Y});
                    board[X][Y] = board[poll[0]][poll[1]] + 1;
                    //이전 값의 +1
                    check[X][Y] = true;

                    //System.out.println("board["+X+"]["+Y+"] = board["+poll[0]+"]["+poll[1]+"] + 1");
                }
            }

            //print();
        }
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
