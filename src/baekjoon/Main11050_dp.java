package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

 */

public class Main11050_dp {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n+1];

        int result = fact(n) / (fact(k) * fact(n-k));
        //System.out.println(Arrays.toString(dp));
        System.out.println(result);

    }

    private static int fact(int num) {
        if(dp[num] > 0){
            //System.out.println(num+"! found");
            return dp[num];
        }

        if(num == 1 || num == 0){
            dp[num] = 1;
            return dp[num];
        }

        dp[num] = fact(num-1) * num;
        //System.out.println(num + "! save");
        return dp[num];
    }
}
