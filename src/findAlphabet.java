import java.util.Scanner;

/*
 * problem : https://www.acmicpc.net/problem/10809
 */

public class findAlphabet {

	public static void main(String[] args) {
		
		String input;
		Scanner sc = new Scanner(System.in);
		int[] d = new int[28];
		for(int i=0;i<28;i++)
			d[i] = -1;
		input = sc.nextLine();
		for(int i=0;i<input.length();i++) {
			
			if(d[input.charAt(i)-'a'] == -1) {
				d[input.charAt(i)-'a'] = i;
			}
			
		}
		for(int i=0;i<26;i++)
		{
			System.out.print(d[i] + " ");
		}
	}
}
