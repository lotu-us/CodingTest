package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*

*/

public class Main1920_binarySearch {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long[] arrN = new long[N];
        for (int i = 0; i < N; i++) {
            arrN[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arrN);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            long num = Long.parseLong(st.nextToken());
            if(binarySearch(arrN, num) >= 0){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int binarySearch(long[] arrN, long key) {
        int left = 0;
        int right = arrN.length -1;

        while(left <= right){
            int mid = (left+right) / 2;

            if(key < arrN[mid]){
                right = mid -1;
            }else if(key > arrN[mid]){
                left = mid +1;
            }else{
                return mid;
            }
        }
        return -1;
    }


}
