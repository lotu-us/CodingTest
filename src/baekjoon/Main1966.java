package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Stack;

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
            int targetDocImportant = 0;
            Queue<Integer> queue = new LinkedList<>();

            //문서 큐에 저장, 문서의 중요도 배열에 저장
            int[] importantArr = new int[9];
            for (int j = 0; j < documentCount; j++) {
                 int order = scanner.nextInt();
                 queue.add(order);
                importantArr[order-1] = importantArr[order-1] + 1;

                 //찾는문서의 값 저장
                if(targetDocIndex == j){
                    targetDocImportant = order;
                }
            }



            //출력순서
            int result = 0;
            boolean stop = false;

            //중요도 높은 순서대로 반복
            for (int important = 8; important >= 0; important--) {
                //중요도 동일한 문서만큼 반복
                for (int count = importantArr[important]-1; count >= 0 ; count--) {

                    //System.out.println("important : " + (important+1) + ", count : " + (count+1) + ", queue : " + queue+", targetDocIndex : "+targetDocIndex);

                    //큐의 값이 현재 중요도와 같다면 삭제대상
                    if(queue.peek() == (important+1)){
                        //삭제
                        queue.remove();

                        //System.out.println("important : "+ (important+1) + ", targetDocValue : " + targetDocImportant+", result : "+(result+1));

                        //찾는문서의 중요도가 현재 중요도와 같다면
                        if( (important+1) >= targetDocImportant && stop == false){
                            result++;   //출력순서 +1
                        }

                        //찾는 문서의 중요도가 현재 중요도와 같고, 찾는문서의 인덱스가 0이면 result stop
                        if(targetDocImportant == (important+1) &&  targetDocIndex == 0){
                            stop = true;
                        }else{
                            targetDocIndex--;
                        }

                    //큐의 값이 현재 중요도와 같지않다면 뒤로 밀기
                    }else{
                        Integer poll = queue.poll();
                        queue.add(poll);
                        important++;

                        //찾는문서의 순서가 0번째면 맨 뒤로, 0번째가 아니면 -1
                        if(targetDocIndex != 0){
                            targetDocIndex--;
                        }else{
                            targetDocIndex = queue.size()-1;
                        }
                    }

                }
            }
            //System.out.println();
            //System.out.println("-------------------------"+result+"------------------------------");
            System.out.println(result);


        }

    }

}
