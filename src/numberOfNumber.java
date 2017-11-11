/*
 * problem : https://www.acmicpc.net/problem/2577
 */
import java.util.*;

public class numberOfNumber {
	static int[] n = {0,1,2,3,4,5,6,7,8,9};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<=9;i++) {
			map.put(n[i], 0);
		}
		int A,B,C;
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		int mul = A*B*C;
		while(true) {
			
			int a = mul%10;
			map.put(a, map.get(a)+1);
			mul /= 10;
			
			if(mul < 10) {
				map.put(mul, map.get(mul)+1);
				break;
			}
			
		}
		for(int i=0;i<=9;i++) {
			System.out.println(map.get(n[i]));
		}
		
		
	}
}
