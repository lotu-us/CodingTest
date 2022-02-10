package SWEA;

import java.util.*;

public class Solution1206 {
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int widthMax = 14;
        int heightMax = 11;
        int test_count = 1;

        for(int test_case = 1; test_case <= test_count; test_case++)
        {
            int buildingCount = sc.nextInt();

            int[][] map = new int[widthMax][heightMax];

            // 빌딩 정보 입력
            for(int width=0; width<buildingCount; width++){
                int heightLimit = sc.nextInt();
                for(int height=0; height<heightLimit; height++){
                    map[width][height] = 1;
                }
            }

            //1층부터 왼쪽 오른쪽 확인
            int count = 0;
            for(int width=(0+2); width<(widthMax-2); width++){	//맨 왼쪽 오른쪽 두칸은 건물 지어지지 않음

                for(int height=0; height<heightMax; height++){
                    boolean left = (map[width-1][height] == 0) && (map[width-2][height] == 0);
                    boolean right = (map[width+1][height] == 0) && (map[width+2][height] == 0);
                    if(map[width][height] == 1 && left && right ){
                        count++;
                    }
                }
            }
            //System.out.println(Arrays.deepToString(map));

            System.out.println(count);
            System.out.println("------------------");
        }

    }
}
