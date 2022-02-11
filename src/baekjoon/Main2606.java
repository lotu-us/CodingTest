package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2606 {
    /*
    7       //컴퓨터의 수
    6       //네트워크에 연결되어있는 컴퓨터 쌍의 수
    1 2     // 1-2 연결됨
    2 3     // 2-3 연결됨
    1 5     // 1-5 연결됨
    5 2     // 5-2 연결됨
    5 6     // 5-6 연결됨
    4 7     // 4-7 연결됨
    * */
    static int[][] node;
    static boolean[] check; //바이러스에 감염되었는지
    static int count = 0;   //감염 컴퓨터 수
    static Queue<Integer> queue = new LinkedList<>();
    static int computers;
    static int pairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computers = Integer.parseInt(br.readLine());
        pairs = Integer.parseInt(br.readLine());

        node = new int[computers+1][computers+1];
        check = new boolean[computers+1];
        for (int i = 0; i < pairs; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine(), " ");
             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());
             node[a][b] = 1;
             node[b][a] = 1;
             //방향성이 없기때문에
        }

        dfs(1);
        System.out.println(count-1);

    }


    public static void dfs(int start) {
        check[start] = true;    // 1번 (start) 감염
        count++;    //감염된 컴퓨터 수 증가

        for (int i = 0; i <= computers; i++) {  //컴퓨터 개수만큼 반복
            if (node[start][i] == 1 && !check[i]) {    //node[start][i] == 1 : 1번(start)과 연결된 노드라면     //!check[i] : i번 컴퓨터가 감염되지 않았다면
                dfs(i); // i번 컴퓨터 감염처리리
            }
        }
    }

}
