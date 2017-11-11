/*
 * https://www.acmicpc.net/problem/1759
 */
import java.util.*;
public class password {

	static int N, M;
	static char[] c;
	static HashMap<Character, Boolean> mm = new HashMap<>();
	
	public static void main(String[] args) {
		
		mm.put('a', true);
		mm.put('e', true);
		mm.put('i', true);
		mm.put('o', true);
		mm.put('u', true);
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		c = new char[M];
		for(int i=0;i<M;i++) {
			c[i] = sc.next().charAt(0);
		}
		Arrays.sort(c);
		for(int i=0;i<M;i++) {
			System.out.print(c[i]+" ");
		}
		System.out.println();
		getPw(1,2,"",0);
	}
	static void getPw(int n1, int n2, String result, int index) {
		
		if(N-result.length() > M-index+1)
			return;
		
		if(result.length() == N) {
			if(n1 <= 0 && n2 <= 0) {
				System.out.println(result);
				return;
			}
			else {
				return;
			}
		}
		
		for(int i=index;i<M;i++) {
			if(mm.containsKey(c[i])) {
				getPw(n1-1,n2,result+c[i],i+1);
			}
			else {
				getPw(n1,n2-1,result+c[i],i+1);
			}
		}
		
		
	}
}
