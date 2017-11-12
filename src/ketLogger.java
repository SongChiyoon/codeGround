/*
 * https://www.acmicpc.net/problem/5397
 */
import java.util.*;

public class ketLogger {

	public static void main(String[] args) {
		//String a = "abcdefg";
		//System.out.println(a.substring(0, 1)+a.substring(1));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			
			String pw = sc.next();
			Stack<Character> s1 = new Stack<>();
			Stack<Character> s2 = new Stack<>();
			for(int i=0;i<pw.length();i++) {

				char c = pw.charAt(i);

				
				if(c=='<') {
					if(s1.isEmpty())
						continue;
					char temp = s1.pop();
					s2.push(temp);
				}else if(c=='>') {
					if(s2.isEmpty())
						continue;
					char temp = s2.pop();
					s1.push(temp);
				}else if(c=='-'){
					if(s1.isEmpty())
						continue;
					s1.pop();
				}else {
					s1.push(c);
				}
			}
			StringBuilder result = new StringBuilder();
			while(!s1.isEmpty()) {
				result.append(s1.pop());
			}
			result.reverse();
			while(!s2.isEmpty()) {
				result.append(s2.pop());
			}
			System.out.println(result);
			
		}
	}
}
