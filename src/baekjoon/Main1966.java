package baekjoon;

import java.io.IOException;
import java.util.*;

public class Main1966 {
    /*
    3           //테스트케이스의 수
    1 0         //문서의개수, 출력순서가 궁금한 문서는 현재 큐의 0번째에 있다 (=5번문서)
    5           //문서의 중요도
                //결과 : 5번이 1번째로 출력되었으니 1

    4 2         //문서의 개수, 출력순서가 궁금한 문서는 현재 큐의 2번째에 있다 (=3번문서)
    1 2 3 4     //문서의 중요도 (최대값 4)
                //문서 재배치 :  1, 2, 3, 4 ->                       //3번 현재 index는 2. 최대값이 3이 아니므로 index--;
                                2, 3, 4, 1 ->                       //3번 현재 index는 1. 최대값이 3이 아니므로 index--;
                                3, 4, 1, 2 ->                       //3번 현재 index는 0. index가 0인데 최대값이 3이 아니므로 index = queue.size-1;
                                4, 1, 2, 3 (4 출력) -> (최대값 3)    //3번 현재 index는 3. 최대값이 3인데 index가 0이 아니면 index--;
                                1, 2, 3 ->                          //3번 현재 index는 2. 최대값이 3인데 index가 0이 아니면 index--;
                                2, 3, 1 ->                          //3번 현재 index는 1. 최대값이 3인데 index가 0이 아니면 index--;
                                3, 1, 2 (3 출력)...                  //3번 현재 index는 0. 최대값이 3인데 index가 0이면 result 출력
                //결과 : 3번이 2번째로 출력되었으니 2

    6 0         //문서의 개수, 출력순서가 궁금한 문서는 현재 큐의 0번째에 있다 (=1-1문서)
    1 1 9 1 1 1 //문서의 중요도 (최대값 9)     구분을 위해 변경 : 1-1  1-2  9  1-3  1-4  1-5
                //문서 재배치 :  1-1  1-2  9  1-3  1-4  1-5 ->                       //1-1번 현재 index는 0. index가 0인데 최대값이 1이 아니므로 index = queue.size-1;
                                1-2  9  1-3  1-4  1-5  1-1 ->                       //1-1번 현재 index는 5. 최대값이 1이 아니므로 index--;
                                9  1-3  1-4  1-5  1-1  1-2 (9출력) -> (최대값 1)     //1-1번 현재 index는 4. 최대값이 1인데 index가 0이 아니면 index--;
                                1-3  1-4  1-5  1-1  1-2 (1-3출력) ->                //1-1번 현재 index는 3. 최대값이 1인데 index가 0이 아니면 index--;
                                1-4  1-5  1-1  1-2 (1-4출력) ->                     //1-1번 현재 index는 2. 최대값이 1인데 index가 0이 아니면 index--;
                                1-5  1-1  1-2 (1-5출력) ->                          //1-1번 현재 index는 1. 최대값이 1인데 index가 0이 아니면 index--;
                                1-1  1-2 (1-1출력)...                               //1-1번 현재 index는 0. 최대값이 1인데 index가 0이면 result 출력
                //결과 : 1-1번이 5번째로 출력되었으니 5
    * */

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testcaseCount = scanner.nextInt();

        //테스트 케이스 수만큼 반복
        for (int i = 0; i < testcaseCount; i++) {
            int documentCount = scanner.nextInt();
            int targetDocIndex = scanner.nextInt();
            Queue<int[]> queue = new LinkedList<>();

            //문서 위치, 중요도 배열에 저장
            int[] importantArr = new int[9];
            for (int j = 0; j < documentCount; j++) {
                int important = scanner.nextInt();
                queue.add(new int[]{ j, important });

                //중요도 횟수 입력
                importantArr[important-1] = importantArr[important-1] + 1;
            }

            int process = process(importantArr, queue, targetDocIndex);
            System.out.println(process);

        }

    }

    public static int process(int[] importantArr, Queue<int[]> queue, int targetDocIndex){
        //몇번째 출력인지
        int result = 0;

        //System.out.println("중요도 등장횟수 : " + Arrays.toString(importantArr));

        //중요도 높은 순서대로 반복
        for (int important=9; important > 0; important--) {

            //중요도 등장횟수만큼 반복
            for (int count = importantArr[important-1]; count > 0; count--) {
                //System.out.println("현재 중요도 : "+important + ", 등장횟수 : "+count + ", " + print(queue));

                //현재 중요도와 문서의 중요도가 일치하면 remove
                if(important == queue.peek()[1]){
                    result++;
                    //찾는 문서의 번호
                    if(targetDocIndex == queue.peek()[0]){
                        //System.out.println("*********** result : " + result);
                        return result;
                    }
                    queue.remove();

                }else{  //현재 중요도와 문서의 중요도가 일치하지 않다면 뒤로 보내기
                    queue.add(queue.poll());

                    //중요도에 해당하는 문서를 지우기 전까지는 루프돌기
                    count++;

                }

            }

        }
        return 0;
    }


    public static String print(Queue<int[]> queue){
        StringBuilder sb = new StringBuilder();
        sb.append("queue : ");
        for (int[] o : queue) {
            sb.append(Arrays.toString(o)+", ");
        }
        return sb.toString();
    }

}
