/*
 * https://www.acmicpc.net/board/view/3640
 */
import java.util.*;
public class betterSequence {

	static int N;
	static boolean flag;
	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		flag = false;
		backTrack("1", 0);
		
		
	}
	public static void backTrack(String seq, int range) {
		
		int pivot;

		if(range > 2)
		for(pivot = range-1; range-pivot < pivot-0 ;pivot--) {
			if(seq.substring(pivot-(range-pivot)-1, pivot).equals(seq.substring(pivot, range+1))) {
				return;
			}
		}
		if(range == N-1) {
			System.out.println(seq);
			flag = true;
			return;
		}		
		
		for(int i=1;i<=3;i++) {
			if(seq.charAt(range)-48 != i) {
				backTrack(seq+i, range+1);
				if(flag)
					break;
			}
		}
		
	}
}
