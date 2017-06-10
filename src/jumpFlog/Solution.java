package jumpFlog;

import java.util.Scanner;
import java.io.FileInputStream;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(new FileInputStream("sample_jumpFlog.txt"));

        //Scanner sc = new Scanner(System.in);

        int T;
        int K;
        int test_case;
        int[] bridge;
        int N;
        int position;
        int count;
        boolean goHead;

        int curr;
        T = sc.nextInt();
        for (test_case = 1; test_case <= T; test_case++) {
            // 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
            N = sc.nextInt()+1;
            bridge = new int[N];
            bridge[0] = 0;

            for (int i = 1; i < N; i++)
                bridge[i] = sc.nextInt();

            K = sc.nextInt();
            position = 0;
            count = 0;
            curr = 0;

            while (curr != N-1) {

                goHead = false;

                for (int j = curr+1; j < N; j++) {
                    if (position + K >= bridge[j]) {
                        curr = j;
                        goHead = true;
                        continue;
                    } else
                        break;
                }
                if (goHead) {
                    count++;
                    position = bridge[curr];
                } else {
                    count = -1;
                    break;
                }
            }

            // 이 부분에서 정답을 출력하십시오.
            System.out.println("#testcase" + test_case);
            System.out.println(count);

        }
    }
}