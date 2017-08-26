import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 27..
 * problem : https://www.acmicpc.net/problem/1120
 */
public class string_similar {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int len = b.length() - a.length();
		int frojnt = 0;
		int ans = Integer.MAX_VALUE;
		
		for(int i=0;i<=len;i++){
			int dif = 0;
			for(int j=0;j<a.length();j++){
				if(b.charAt(i+j) != a.charAt(j))
					dif++;
			}
			ans = Math.min(ans, dif);
		}
		System.out.println(ans);
		
		
	}
}
