/*
 * https://www.acmicpc.net/problem/10814
 */
import java.util.*;
public class AgeOrdering {

	static class person implements Comparable<person>{
		int age;
		String name;
		int order;
		person(int age, String name, int order){
			this.age = age;
			this.name = name;
			this.order = order;
		}

		@Override
		public int compareTo(person other) {
			
			if(this.age == other.age)
				return Integer.compare(this.order, other.order);
			else
				return Integer.compare(this.age, other.age);
		}
		
	}
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<person> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++){
			int age = sc.nextInt();
			String name = sc.next();
			person p = new person(age, name, i);
			pq.add(p);
			
		}
		StringBuilder result = new StringBuilder();
		while(!pq.isEmpty()){
			person active = pq.remove();
			result.append(active.age +" "+active.name +"\n");
		}
		System.out.println(result);
		
	}
}
