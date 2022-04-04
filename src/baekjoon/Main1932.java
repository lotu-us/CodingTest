package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 */
public class Main1932 {

    static int[][] triangle = null;
    static int sum = 0;
    static int N = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        triangle = new int[N][N];

        //입력받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = st.countTokens();
            for (int j = 0; j < count; j++) {
                 triangle[i][j] = Integer.parseInt(st.nextToken());
                 process(i, j);
                 sum = Math.max(sum, triangle[i][j]);
            }
            //print();
        }

        System.out.println(sum);
    }



    private static void process(int i, int j) {
        //System.out.println("("+i+", "+j+")");

        if(i-1 < 0){
            return;
        }

        int tempA = 0;
        if(j-1 >= 0){
            tempA = triangle[i-1][j-1] + triangle[i][j];
        }
        int tempB = triangle[i-1][j] + triangle[i][j];

        triangle[i][j] = Math.max(tempA, tempB);
        //sum = Math.max(sum, triangle[i][j]);
        //N이 1일때 sum은 계속 0으로 나올수밖에 없다
    }


    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
