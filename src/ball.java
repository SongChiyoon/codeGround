/*
 * https://www.acmicpc.net/problem/1547
 */
import java.util.*;
public class ball {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int index = 1;
		int M = sc.nextInt();
		int swap_x, swap_y;
		for(int i=0;i<M;i++) {
			
			swap_x = sc.nextInt();
			swap_y = sc.nextInt();
			if(swap_x == index)
				index = swap_y;
			else if(swap_y == index)
				index = swap_x;
			else
				continue;
			
		}
		System.out.println(index);
		
	}
}
