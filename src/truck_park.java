import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 27..
 * problem : https://www.acmicpc.net/problem/2979
 */
public class truck_park {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int[] t = new int[4];
		
		int[] c = new int[51];
		int len = Integer.MIN_VALUE;
		for(int i=0;i<3;i++){
			int s = sc.nextInt();
			int f = sc.nextInt();
			c[s] += 1;
			if(f <= 50)
				c[f] -= 1;
			len = Math.max(len, f);
		}
		int index = 0;
		for(int i=0;i<=len;i++){
			index += c[i];
			System.out.print(index+" ");
			t[index]++;
		}
		System.out.println();
		System.out.println(t[1]*A + t[2]*B*2 + t[3]*C*3);
	}

}
