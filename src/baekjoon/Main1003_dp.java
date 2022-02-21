package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

*/
public class Main1003_dp {

    static int[] fibo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        fibo = new int[40+1];
        fibo[0] = 1;
        fibo[1] = 1;
        for (int i = 2; i < fibo.length; i++) {
            fibonacci(i);
        }

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                System.out.println("1 0");
            }else if(num == 1){
                System.out.println("0 1");
            }else{
                System.out.println(fibo[num-2]+" "+fibo[num-1]);
            }
        }
    }

    private static int fibonacci(int n){

        if(n == 0){
            return fibo[0];
        }else if(n == 1){
            return fibo[1];
        }else{
            if(fibo[n] == 0){
                fibo[n] = fibo[n-1] + fibo[n-2];
                return fibo[n];
            }
            return fibo[n];
        }
    }
}
