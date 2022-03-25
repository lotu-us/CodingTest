package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
DP문제

정수 n은 양수이며 11보다 작다. 1, 2, 3의 합으로 나타내야한다.
[0]~[11]생성
[1]은 1가지 (1)
[2]은 2가지 (1+1, 2)
[3]은 4가지 (1+1+1, 1+2, 2+1, 3)
[4]은 7가지 (1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1) = [3]+[2]+[1]
[5]는 13가지 (1+1+1+1+1,
        1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1,
        1+1+3, 1+3+1, 3+1+1,
        2+2+1, 2+1+2, 1+2+2,
        3+2, 2+3) = [4]+[3]+[2]
*/
public class Main9095 {

    static int[] nums = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 4;

        //배열 값 셋팅
        for (int i = 4; i <= 10; i++) {
             nums[i] = nums[i-3] + nums[i-2] + nums[i-1];
        }


        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(nums[n]);
        }
    }

}
