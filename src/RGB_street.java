import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 31..
 * problem : https://www.acmicpc.net/problem/1149
 */
public class RGB_street {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] rgb = new int[3];
		for(int t=0;t<T;t++){
			
			int r = sc.nextInt();
			int g = sc.nextInt();
			int b = sc.nextInt();
			if(t == 0){
				rgb[0] = r;
				rgb[1] = g;
				rgb[2] = b;
				continue;
			}
			int temp_r = rgb[0];
			int temp_g = rgb[1];
			int temp_b = rgb[2];
			rgb[0] = Math.min(temp_g, temp_b) + r;
			rgb[1] = Math.min(temp_r, temp_b) + g;
			rgb[2] = Math.min(temp_r, temp_g) + b;
		}
		System.out.println(rgb[0]+","+rgb[1]+","+rgb[2]);

		System.out.println(Math.min(Math.min(rgb[0], rgb[1]), rgb[2]));
	}
}
