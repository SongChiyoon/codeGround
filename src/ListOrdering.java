/*
 * https://www.acmicpc.net/problem/1015
 */
import java.util.*;
public class ListOrdering {

	static class Number implements Comparable<Number>{
		
		int num, position;

		Number(int num, int position){
			this.num = num;
			this.position = position;
		}
		@Override
		public int compareTo(Number other) {
			if(this.num != other.num)
				return Integer.compare(this.num, other.num);
			return Integer.compare(this.position, other.position);
		}
		
	}
	public static void main(String[] args){
		
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt();
		Number[] arr = new Number[N];
		int[] P = new int[N];
		for(int i=0;i<N;i++){
			arr[i] = new Number(sc.nextInt(), i);
		}
		Arrays.sort(arr);
		for(int i=0;i<N;i++){
			P[arr[i].position] = i;
		}
		for(int i=0;i<N;i++)
			System.out.print(P[i] + " ");

	}
}
