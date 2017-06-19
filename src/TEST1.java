import java.util.Scanner;

public class TEST1 {
	public static void main(String[] args){
		if((11&1) == 1)
			System.out.println(11&1);
		
		
		int N;
		Scanner sc = new Scanner(System.in);
		/*N = sc.nextInt();
		
		for(int i = 1; i <= 9; i++)
			System.out.println(N*i);
		*/
		String asd = "asdsadsa";
		int a = 12345;
		String as = String.valueOf(a);
		System.out.println(as);
		char[] b = new char[as.length()];
		for(int i = as.length()-1; i >= 0; i--)
			b[as.length() - (i+1)] = as.charAt(i);
		
		int bi = Integer.valueOf(String.copyValueOf(b));
		System.out.println(bi);
	}
}
