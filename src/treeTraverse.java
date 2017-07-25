import java.util.HashMap;
import java.util.Scanner;
/**
 * Created by songchiyun on 2017. 7. 25..
 * 문제 : https://www.acmicpc.net/problem/2263
 */
public class treeTraverse {
	static int[] in;
	static int[] pos;
	static int[] pre;
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		in = new int[N];
		pos = new int[N];
		pre = new int[N];
		
		for(int i=0;i<N;i++){
			in[i] = sc.nextInt();
			map.put(in[i], i);
		}
		for(int i=0;i<N;i++){
			pos[i] = sc.nextInt();
		}
		
		solve(0, N-1, 0, N-1);
	}
	public static void solve(int il, int ir, int pol, int por){
		
		if(il > ir || pol > por)
			return;

		int root = pos[por];
		System.out.print(root + " ");
		
		int iroot = map.get(root);
		//root search
		
		int left= iroot - il;
		// left side
		solve(il, iroot-1,pol, pol+left-1);
		// right side
		solve(iroot+1, ir, pol+left, por-1);
	}
}
