import java.util.Scanner;

/*
 *  problem : https://www.acmicpc.net/problem/1152
 */

public class NumberOfWords {

	public static void main(String[] args) {
		
		String input;
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		int count = 0;
		boolean wordStart = true;
		for(int i=0;i<input.length();i++) {
			
			if(input.charAt(i) == ' ') {
				wordStart = true;
			}
			else {
				if(wordStart) {
					wordStart = false;
					count++;
				}
			}
			
		}
		
		
		System.out.println(count);
		
		
	}
}
