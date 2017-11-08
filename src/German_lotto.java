import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * problem : https://www.acmicpc.net/problem/6603
 */
public class German_lotto {

	static int k;
	static int[] S;
	static boolean[] v;
	static StringBuilder result;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			k = sc.nextInt();
			if(k == 0)
				break;
			S = new int[k];
			v = new boolean[k];
			int[] nums = new int[6];
			for(int i=0;i<k;i++)
				S[i] = sc.nextInt();
			for(int i=0;6<=k-i;i++) {
				nums[0] = S[i];
				find(i, nums, 1);
			}
			System.out.println();
		}
	}
	static void find(int current, int[] num, int index) {
		if(index == 6) {
			for(int i=0;i<6;i++) {
				System.out.print(num[i] +" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=current+1;i<k;i++) {
			num[index] = S[i];
			find(i, num, index+1);
		}
	}
	
}
