package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1149 {

    static int[][] cost = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cost = new int[N+1][3];

        //입력받기
        for (int n = 1; n <= N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red, green, blue = 0;

            red = Integer.parseInt(st.nextToken());    //red
            green = Integer.parseInt(st.nextToken());   //green
            blue = Integer.parseInt(st.nextToken());    //blue

            cost[n][0] = red;
            cost[n][1] = green;
            cost[n][2] = blue;

            paint(n, red, green, blue);
        }


        int min = Math.min(cost[N][0], cost[N][1]);
        min = Math.min(min, cost[N][2]);
        System.out.println(min);
    }

    private static void paint(int n, int red, int green, int blue) {

        //최소값
        cost[n][0] = Math.min(cost[n-1][1], cost[n-1][2]) + cost[n][0];
        cost[n][1] = Math.min(cost[n-1][0], cost[n-1][2]) + cost[n][1];
        cost[n][2] = Math.min(cost[n-1][0], cost[n-1][1]) + cost[n][2];
    }


}

