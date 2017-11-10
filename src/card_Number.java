/*
 * problem : https://www.acmicpc.net/problem/10815
 */
import java.util.*;
public class card_Number {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] s = new long[N];
		HashMap<Long, Boolean> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			long input = sc.nextLong();
			map.put(input, true);
		}
		Arrays.sort(s);
		
		int M = sc.nextInt();
		long[] d = new long[M];
		for(int i=0;i<M;i++) {
			long find = sc.nextLong();
			if(map.containsKey(find))
				System.out.print("1 ");
			else
				System.out.print("0 ");
		}
		
	}
}
