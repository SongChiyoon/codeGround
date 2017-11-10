/*
 * problem : https://www.acmicpc.net/problem/9012
 */
import java.util.*;

public class bracket {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0;i<N;i++) {
			String input = sc.next();
			boolean flag = true;
			Stack<Character> s = new Stack<>();
			for(int j=0; j<input.length();j++) {
				
				if(input.charAt(j) == '(') {
					s.push('(');
				}
				else {
					if(s.isEmpty()) {
						System.out.println("NO");
						flag = false;
						break;
					}
					else
						s.pop();
				}
				
			}
			if(flag) {
				if(!s.isEmpty())
					System.out.println("NO");
				else
					System.out.println("YES");
			}
		}
	}
}
