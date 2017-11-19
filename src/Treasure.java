/*
 * https://www.acmicpc.net/problem/1026
 */
import java.util.*;
public class Treasure {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> A = new ArrayList<>();
		int[] B = new int[N];
		for(int i=0;i<N;i++)
			A.add(sc.nextInt());
		for(int i=0;i<N;i++)
			B[i] = sc.nextInt();
		
		Arrays.sort(B);
		Comparator<Integer> reverseSort = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer a1, Integer a2) {
				return -Integer.compare(a1, a2);
			}
		};
		Collections.sort(A, reverseSort);
		int sum = 0;
		for(int i=0;i<N;i++) {
			
			sum += A.get(i)*B[i];
		}
		System.out.println(sum);
		
	
	}
}
