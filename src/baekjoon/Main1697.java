package baekjoon;

import java.io.IOException;
import java.util.*;

public class Main1697 {
    /*
    5 17    //수빈이의 위치, 동생의 위치

    가장 빠른 시간 : bfs사용해라
    시작위치는 1초에 방문한 곳이니까 [5] = 1
    2초에는 3가지 방법 존재
        걷기 -1 : [4] 2초에 방문한 곳이니까 [4] = 2
        걷기 +1 : [6] 2초에 방문한 곳이니까 [6] = 2
        순간이동 *2 : [10] 2초에 방문한 곳이니까 [10] = 2

    2초에서 [4]로 이동했다고하면,
    3초에는 3가지 방법 존재
        걷기 -1 : [3] = 3
        걷기 +1 : [5].. 이미 방문한 적이 있다면 패스
        순간이동 *2 : [8] = 3 ...

    [node]                     **                                                          **
    | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 10 | 11 | 12 | 13 | 14 | 15 | 16 | 17 | 18 | 19 | 20 |
0초 |    |    |    |    |    |  1 |    |    |    |    |    |    |    |    |    |    |    |    |    |    |    |
1초 |    |    |    |    |  2 |    |  2 |    |    |    |  2 |    |    |    |    |    |    |    |    |    |    |
2초 |    |    |    |  3 |    |    |    |  3 |  3 |  3 |    |  3 |  3 |    |    |    |    |    |    |    |  3 |
3초 |    |    |  4 |    |    |    |    |    |    |    |    |    |    |  4 |  4 |    |  4 |    |  4 |    |    |
4초 |    |  5 |    |    |    |    |    |    |    |    |    |    |    |    |    |  5 |    |  5 |    |    |    |

    총 경로 : [5] -1   ->  [4] * 2   ->   [8] * 2   ->    [16] + 1

    * */

    static int length = 100000;
    static int[] node = new int[length+1];
    static Queue<Integer> queue = new LinkedList<>();
    static int goal;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int start = scan.nextInt();
        goal = scan.nextInt();

        int time = bfs(start)-1;
        System.out.println(time);
    }

    private static int bfs(int start) {
        queue.offer(start);
        node[start] = 1;   //0초로 하면 방문했는지 알 수 없기때문에 1초로 기재하고, 결과값에서 -1 하기로한다

        while(!queue.isEmpty()){
            int temp = queue.poll();
            //System.out.print("time : " + node[temp] + ", 현재노드 : " + temp + ", 방문노드 : ");

            //움직일 수 있는 방법의 가지 수
            int index = 0;
            for (int i = 0; i < 3; i++) {
                switch (i){
                    case 0 : index = temp-1; break;
                    case 1 : index = temp+1; break;
                    case 2 : index = temp*2; break;
                }

                if(index >=0 && index <= length && node[index] == 0){  //방문하지 않은 곳이라면
                    //node[index] == 0 만 했더니 ArrayIndexOutOfBounds가 발생했다.
                    // index >=0 && index <= length 를 뒤에 붙여주어도 동일하게 오류가 발생했다.
                    queue.offer(index);
                    node[index] = node[temp] + 1;
                }
                //System.out.print(index + ", ");

                if(index == goal){
                    return node[index];
                }
            }
            //System.out.println();
        }
        return 0;
    }

}
