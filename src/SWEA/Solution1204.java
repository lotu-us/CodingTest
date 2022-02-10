package SWEA;

import java.util.*;
import java.io.FileInputStream;

public class Solution1204 {
    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {	int testNum = sc.nextInt();
            //System.out.println(testNum + "번째");

            int[] scoreArr = new int[1000];
            int[] scoreCountArr = new int[101];	//0도 포함해야함

            //점수 등장횟수 입력
            for(int i=0; i<1000; i++){
                int score = sc.nextInt();
                scoreArr[i] = score;
                scoreCountArr[score] = scoreCountArr[score] +1;
            }


            //점수 등장횟수의 최대값 구하기
            int max = 0;
            //점수 등장횟수의 최대값에 해당하는 숫자 가져오기
            int result = 0;
            for(int i=100; i>=0; i--){
                if(scoreCountArr[i] > max){
                    max = scoreCountArr[i];
                    result = i;
                }
            }
            System.out.println("#" + testNum + " " + result);

        }
    }
}
