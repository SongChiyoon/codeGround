/*
 * https://www.acmicpc.net/problem/11723
 */
import java.util.*;
public class set {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Boolean> map = new HashMap<>();
		StringBuilder result = new StringBuilder();
		int M = sc.nextInt();
		
		for(int m=0;m<M;m++) {
			
			String action = sc.next();
			if(action.equals("all")) {
				for(int i=1;i<=20;i++)
					map.put(i, true);
			}
			else if(action.equals("empty")) {
				for(int i=1;i<=20;i++)
					map.remove(i);
			}
			else if(action.equals("add"))
				map.put(Integer.parseInt(sc.next()), true);
			
			else if(action.equals("remove"))
				map.remove(Integer.parseInt(sc.next()));
			
			else if(action.equals("check")) {
				if(map.containsKey((Integer.parseInt(sc.next()))))
					result.append("1\n");
				else
					result.append("0\n");
			}
			else {
				int get = Integer.parseInt(sc.next());
				
				if(map.containsKey((get)))
					map.remove(get);
				else
					map.put(get, true);
			}
			
			
			
		}
		System.out.println(result);
		
		
	}
}
