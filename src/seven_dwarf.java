import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 9. 22..
 * problem : https://www.acmicpc.net/problem/2309
 */
public class seven_dwarf {

	static int[] d;
	static int N;
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		N = 9;
		d = new int[N];
		int sum = 0;
		for(int i=0;i<N;i++){
			d[i] = sc.nextInt();
			sum += d[i];
		}
		Arrays.sort(d);
		List<Integer> result = go(sum);

		boolean g;
		for(int ans : d){
			g = true;
			for(int a : result){
				if(ans == a)
					g = false;
			}
			if(g)
				System.out.println(ans);
		}
		
		
	}
	static List<Integer> go(int sum){
		List<Integer> result = new LinkedList<>();
		for(int i=0;i<N-1;i++){
			sum -= d[i];
			for(int j=i+1;j<N;j++){
				sum -= d[j];
	
				if(sum == 100){
					result.add(d[i]);
					result.add(d[j]);
					return result;
				}
				else
				sum += d[j];
			}
			sum += d[i];
		}
		return result;
	}
}
