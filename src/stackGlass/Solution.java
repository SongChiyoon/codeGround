package stackGlass;

import java.util.Scanner;
import java.io.FileInputStream;

/* �궗�슜�븯�뒗 �겢�옒�뒪紐낆씠 Solution �씠�뼱�빞 �븯硫�, 媛�湲됱쟻 Solution.java 瑜� �궗�슜�븷 寃껋쓣 沅뚯옣�빀�땲�떎.
   �씠�윭�븳 �긽�솴�뿉�꽌�룄 �룞�씪�븯寃� java Solution 紐낅졊�쑝濡� �봽濡쒓렇�옩�쓣 �닔�뻾�빐 蹂� �닔 �엳�뒿�땲�떎. */

class Solution {
    public static void main(String args[]) throws Exception	{

		Scanner sc = new Scanner(new FileInputStream("sample-3.txt"));
        


		int T;
		int test_case;
		int N;
		int[][] c;
		int result = 0;
		int[][] compare;
		int max, maxIndex, pre = -1;
		T = sc.nextInt();
		int dCount;
		for(test_case = 1; test_case <= T; test_case++) {
			dCount = 0;
			N = sc.nextInt();
			c = new int[N][];
			compare = new int[N][];
			for(int i = 0; i < N; i++){
				int h = sc.nextInt();
				c[i] = new int[h+1];
				c[i][0] = h;
				for(int j = 1 ; j <= h; j++)
					c[i][j] = sc.nextInt();
				compare[i] = new int[2];
				compare[i][0] = 1;
				compare[i][1] = c[i][1];
			}
			while(result == 0) {
				maxIndex = 0;
				for (int i = 1; i < N; i++) {
					if(compare[i][0] < c[i][0]  && compare[i][1] > compare[maxIndex][1])
						maxIndex = i;
				}
				compare[maxIndex][0] += 1;
				if(pre != -1) {
					if(pre != maxIndex)
						dCount++;
				}
				pre = maxIndex;
				if(compare[maxIndex][0] <= c[maxIndex][0])
					compare[maxIndex][1] = c[maxIndex][compare[maxIndex][0]];
			}


			System.out.println("#testcase" + test_case);
			System.out.println();
			
		}
	}
}