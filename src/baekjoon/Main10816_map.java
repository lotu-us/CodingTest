package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*

*/
public class Main10816_map {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
             int num = Integer.parseInt(st.nextToken());
             if(map.get(num) == null){
                 map.put(num, 1);
             }else{
                map.put(num, map.get(num)+1);
             }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(map.get(num) == null){
                sb.append(0).append(" ");
            }else{
                sb.append(map.get(num)).append(" ");
            }

        }

        System.out.println(sb);

    }

}
