package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
InputStream - byte
InputStreamReader - character
BufferedReader - String
*/
public class Main1260_bfs_dfs {

    //dfs
    static int[][] dfsBoard = new int[1000+1][1000+1];
    static boolean[] dfsCheck = new boolean[1000+1]; //이동체크
    static StringBuilder dfsSb = new StringBuilder();

    //bfs
    static int[][] bfsBoard = new int[1000+1][1000+1];
    static boolean[] bfsCheck = new boolean[1000+1]; //이동체크
    static Queue<Integer> queue = new LinkedList<Integer>();
    static StringBuilder bfsSb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //정점개수
        int M = Integer.parseInt(st.nextToken());   //간선개수
        int V = Integer.parseInt(st.nextToken());   //시작번호

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dfsBoard[a][b] = 1;    // a -> b OK
            dfsBoard[b][a] = 1;    // b -> a OK

            bfsBoard[a][b] = 1;
            bfsBoard[b][a] = 1;
        }

        dfs(V);
        System.out.println(dfsSb);

        bfs(V);
        System.out.println(bfsSb);
    }

    private static void dfs(int start) {
        dfsCheck[start] = true;
        dfsSb.append(start).append(" ");

        for (int i = 1; i < 1001; i++) {
            if(dfsBoard[start][i] == 1 && dfsCheck[i] == false){
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        queue.offer(start); //값 추가
        bfsCheck[start] = true;

        while(!queue.isEmpty()){
            int poll = queue.poll();
            bfsSb.append(poll).append(" ");

            for (int i = 0; i < 1001; i++) {
                if(bfsBoard[poll][i] == 1 && bfsCheck[i] == false){
                    queue.offer(i);
                    bfsCheck[i] = true;
                }
            }
        }

    }

}
