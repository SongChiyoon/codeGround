/*
 * https://www.acmicpc.net/problem/1427
 */
import java.math.BigInteger;
import java.util.*;
public class sortInside {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		//BigInteger input  = new BigInteger(line);
		int[] data = new int[line.length()];
		for(int i=0;i<line.length();i++) {
			data[i] = Integer.parseInt(line.charAt(i)+"");
		}
		Arrays.sort(data);
		for(int i=0;i<line.length();i++)
			System.out.print(data[i]);
	}
	
}
