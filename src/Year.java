import java.util.*;
public class Year {

	static int[] m = {31,28,31,30,31,30,31,31,30,31,30,31};
	static String[] d = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
	
	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int ans = 0;
		for(int i=x;i-1>0;i--) {
			ans += m[i-2];
		}
		ans += y-1;
		System.out.println(d[ans%7]);
	}
}
