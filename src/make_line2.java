import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/* Created by songchiyun on 2017. 9. 9..
 * problem : https://www.acmicpc.net/problem/2252
 */
public class make_line2 {

	static class p{
		List<edge> edgeList;
		int degree;
		p(){
			degree = 0;
			edgeList = new LinkedList<>();
			
		}
		public void addEdge(edge e){
			this.edgeList.add(e);
		}
	}
	static class edge{
		int t;
		edge(int t){
			this.t= t;
		}
	}
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		p[] d = new p[N+1];
		for(int i=1;i<=N;i++)
			d[i] = new p();
		for(int i=0;i<M;i++){
			int s= sc.nextInt();
			int t= sc.nextInt();
			d[t].degree++;
			d[s].addEdge(new edge(t));
		}
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();
		for(int i=1;i<=N;i++){
			if(d[i].degree == 0){
				q.add(i);
			}
		}
		while( !q.isEmpty() ){
			
			int a = q.remove();
			result.add(a);
			for(edge e : d[a].edgeList ){
				d[e.t].degree--;
				
				if(d[e.t].degree == 0){
					q.add(e.t);
				}
				
			}
		}
		while( !result.isEmpty() ){
			int r = result.remove();
			System.out.print(r +" ");
		}
		
	}
}
